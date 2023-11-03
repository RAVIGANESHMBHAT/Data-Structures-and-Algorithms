package Sorting_Algorithms;

public class ShellSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private boolean less(T v, T w) {
        return v.compareTo((T) w) < 0;
    }

    private void exch(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // Create an array of a type that implements Comparable (e.g., Integer).
        Integer[] arrayToSort = { 5, 2, 8, 1, 4, 7 };

        // Create an instance of ShellSort for Integer type.
        ShellSort<Integer> integerSorter = new ShellSort<>();

        // Call the sort method to sort the array.
        integerSorter.sort(arrayToSort);

        // Print the sorted array.
        for (Integer num : arrayToSort) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}