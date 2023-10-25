package Stack;

public class GenericStackUsingLinkedList<ItemType> {
    private Node first = null;

    private class Node {
        ItemType item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(ItemType item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public ItemType pop() {
        ItemType item = first.item;
        first = first.next;
        return item;
    }
}
