package Stack;

public class StackUsingResizingArray {
    private String[] s;
    private int N = 0;

    public StackUsingResizingArray() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length) {
            resizeArray(2 * s.length);
        }
        s[N++] = item;
    }

    private void resizeArray(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public String pop() {
        if (N - 1 < 0) {
            System.out.println("Stack Underflow");
            return "";
        }
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) {
            resizeArray((s.length / 2));
        }
        return item;
    }
}
