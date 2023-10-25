package Stack;

// We can create a fixed size stack when using an array
public class StackUsingFixedArray {
    private String[] s;
    private int N = 0;

    public StackUsingFixedArray(int capacity) {
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        if (N >= s.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        s[N++] = item;
    }

    public String pop() {
        if (N - 1 < 0) {
            System.out.println("Stack Underflow");
            return "";
        }
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
