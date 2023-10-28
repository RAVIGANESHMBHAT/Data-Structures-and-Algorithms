package Stack;

public class StackOfNumbersUsingResizingArray {
    private int[] s;
    private int N = 0;

    public StackOfNumbersUsingResizingArray() {
        s = new int[1];
    }

    public void push(int item) {
        if (N == s.length) {
            resizeArray(2 * s.length);
        }
        s[N++] = item;
    }

    private void resizeArray(int capacity) {
        int[] copy = new int[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public int pop() {
        if (N - 1 < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int item = s[--N];
        s[N] = -1;
        if (N > 0 && N == s.length / 4) {
            resizeArray((s.length / 2));
        }
        return item;
    }

    public int maxItem() {
        int max = s[0];
        for (int i = 0; i < N; i++) {
            if (s[i] > max) {
                max = s[i];
            }
        }
        return max;
    }
}
