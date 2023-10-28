package Queue;

import java.util.Stack;

public class QueueUsingTwoStacks<T> {
    private Stack<T> pushStack;
    private Stack<T> popStack;
    private int size;

    public QueueUsingTwoStacks() {
        pushStack = new Stack<T>();
        popStack = new Stack<T>();
        size = 0;
    }

    public void enqueue(T item) {
        pushStack.push(item);
        size++;
    }

    public T dequeue() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        T item = null;
        if (!popStack.isEmpty()) {
            item = popStack.pop();
        }
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<String> q = new QueueUsingTwoStacks<String>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        System.out.println(q.dequeue());
    }
}
