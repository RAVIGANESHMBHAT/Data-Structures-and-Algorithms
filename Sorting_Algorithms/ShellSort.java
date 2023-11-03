package Sorting_Algorithms;

public class ShellSort<T extends Comparable<T>> {
    public void sort(T[] a) {
        int N = a.length;

        int gap = 1;
        while (gap < N / 3)
            gap = 3 * gap + 1;

        while (gap >= 1) {
            // Perform insertion sort on sub-arrays with the given gap
            for (int i = gap; i < N; i++) {
                for (int j = i; j >= gap && less(a[j], a[j - gap]); j -= gap) {
                    exch(a, j, j - gap);
                }
            }
            gap /= 3;
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

        System.out.println("Array Before Sorting:");
        for (Integer num : arrayToSort) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // Create an instance of ShellSort for Integer type.
        ShellSort<Integer> integerSorter = new ShellSort<>();

        // Call the sort method to sort the array.
        integerSorter.sort(arrayToSort);

        System.out.println("Sorted Array:");
        // Print the sorted array.
        for (Integer num : arrayToSort) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}