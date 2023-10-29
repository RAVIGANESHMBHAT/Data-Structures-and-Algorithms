package Stack;

import java.util.Iterator;

class Node<TItem> {
    TItem item;
    Node<TItem> next;
}

class StackIteratorClass<Item> implements Iterable<Item> {
    private Node<Item> first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

public class StackIterator {
    public static void main(String[] args) {
        StackIteratorClass<Integer> s = new StackIteratorClass<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        Iterator<Integer> stackIterator = s.iterator();
        while (stackIterator.hasNext()) {
            System.out.println(stackIterator.next());
        }
    }
}
