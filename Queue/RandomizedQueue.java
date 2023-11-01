import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
        items = (Item[]) new Object[1];
    }


    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items in the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("NULL cannot be a value to add.");
        if (n == items.length) {
            resize(2 * items.length);
        }
        items[n] = item;
        n++;
    }

    // delete and return a random item
    public Item dequeue() {
        emptyCheck();
        int rand = StdRandom.uniform(n);
        Item elt = items[rand];
        if (n - 1 == rand) {
            items[rand] = null;
        } else {
            items[rand] = items[n - 1];
            items[n - 1] = null;
        }
        if (n > 0 && n == items.length / 4) {
            resize(items.length / 2);
        }
        n--;
        return elt;
    }

    // return (but do not delete) a random item
    public Item sample() {
        emptyCheck();
        int rand = StdRandom.uniform(n);
        return items[rand];

    }

    private void emptyCheck() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {
        int len = n;

        public boolean hasNext() {
            return len != 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int rand = StdRandom.uniform(len);
            Item item = items[rand];
            if (rand == len - 1) {
                len--;
                return item;
            } else {
                items[rand] = items[len - 1];
                items[len - 1] = item;
                len--;
                return item;
            }

        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(4);
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(6);
        Iterator<Integer> it = randomizedQueue.iterator();
        while (it.hasNext()) {
            int elt = it.next();
            System.out.println(elt + " ");
        }
    }
}
