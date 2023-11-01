package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validateBeforeAdd(item);
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validateBeforeAdd(item);
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    private void validateBeforeAdd(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
    }

    // remove and return the item from the front
    public Item removeFirst() {
        validateBeforeRemove();
        Item item = first.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        validateBeforeRemove();
        Item item = last.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
        return item;
    }

    private void validateBeforeRemove() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty.");
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // DequeIterator for iterating over the deque
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported.");
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more items to return.");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // Unit testing (required)
    public static void main(String[] args) {
        Deque<Number> deque = new Deque<>();

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        for (Number item : deque) {
            System.out.print(item + " ");
        }
        System.out.println();

        deque.removeFirst();
        deque.removeLast();

        for (Number item : deque) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
