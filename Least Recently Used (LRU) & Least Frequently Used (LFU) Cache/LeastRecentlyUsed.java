import java.util.HashMap;

class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LeastRecentlyUsedLRU {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

    LeastRecentlyUsedLRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node) {
        map.put(node.key, node);

        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;

        // node.next = head.next;
        // node.prev = head;
        // head.next = node;
        // if (node.next != null) {
        // node.next.prev = node;
        // }
    }

    void deleteNode(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int res = resNode.val;
            deleteNode(resNode);
            addNode(resNode);
            return res;
        }
        return -1;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            Node exitingNode = map.get(key);
            deleteNode(exitingNode);
        }
        if (map.size() == capacity) {
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
    }
}

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        LeastRecentlyUsedLRU lru = new LeastRecentlyUsedLRU(3);

        lru.addNode(new Node(1, 10));
        lru.addNode(new Node(2, 20));

        System.out.println(lru.get(1));
        System.out.println(lru.get(3));

        lru.addNode(new Node(3, 30));
        lru.addNode(new Node(4, 40));

        System.out.println(lru.get(3));
    }
}
