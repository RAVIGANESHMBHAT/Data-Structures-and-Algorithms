import java.util.HashMap;

// Throws NullPointerException. Refer to LFU.java for correct code

class Node {
    int key, val, count;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        count = 1;
        prev = null;
        next = null;
    }
}

class List {
    int size;
    Node head, tail;

    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

}

class LeastFrequentlyUsedLFU {
    HashMap<Integer, Node> keyNodeMap;
    HashMap<Integer, List> freqListMap;
    int maxCacheSize, leastFrequency, currentCacheSize;

    LeastFrequentlyUsedLFU(int capacity) {
        freqListMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
        maxCacheSize = capacity;
        leastFrequency = 1;
        currentCacheSize = 0;
    }

    void updateFreqListMap(Node node) {
        keyNodeMap.remove(node.key);
        freqListMap.get(node.count).removeNode(node);
        if (node.count == leastFrequency || freqListMap.get(node.count).size == 0) {
            leastFrequency++;
        }
        List nextHigherFreqList = new List();
        if (freqListMap.containsKey(node.count + 1)) {
            nextHigherFreqList = freqListMap.get(node.count + 1);
        }
        node.count++;
        nextHigherFreqList.addFront(node);
        freqListMap.put(node.count, nextHigherFreqList);
        keyNodeMap.put(node.key, node);
    }

    int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node currentNode = keyNodeMap.get(key);
            int value = currentNode.val;
            updateFreqListMap(currentNode);
            return value;
        }
        return -1;
    }

    void put(int key, int value) {
        if (maxCacheSize == 0) {
            return;
        }
        if (keyNodeMap.containsKey(key)) {
            Node existingNode = keyNodeMap.get(key);
            existingNode.val = value;
            updateFreqListMap(existingNode);
        }
        // inserting a new element
        else {
            if (currentCacheSize == maxCacheSize) {
                List minFreqList = freqListMap.get(currentCacheSize);
                keyNodeMap.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currentCacheSize--;
            }
            currentCacheSize++;
            // new value has to be added which was not there previously
            leastFrequency = 1;
            List listFreq = new List();
            if (freqListMap.containsKey(leastFrequency)) {
                listFreq = freqListMap.get(leastFrequency);
            }
            Node newNode = new Node(key, value);
            listFreq.addFront(newNode);
            freqListMap.put(leastFrequency, listFreq);
        }
    }
}

public class LeastFrequentlyUsed {
    public static void main(String[] args) {
        LeastFrequentlyUsedLFU lfu = new LeastFrequentlyUsedLFU(3);
        lfu.put(1, 9);
        lfu.put(2, 20);
        lfu.put(1, 10);
        lfu.put(3, 30);

        System.out.println(lfu.get(1));

        lfu.put(4, 40);

        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
    }
}
