package Sorting_Algorithms;

public class MergeSortBottomUp<T extends Comparable<T>> {
    private void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // copy
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

        assert isSorted(a, lo, hi);
    }

    private boolean less(T a, T b) {
        return a.compareTo((T) b) < 0;
    }

    // Check if the array is sorted in non-decreasing order
    private boolean isSorted(T[] a, int lo, int hi) {
        boolean sorted = true;
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                sorted = false;
                return sorted;
            }
        }
        return sorted;
    }

    public void sort(T[] a) {
        int N = a.length;
        T[] aux = (T[]) new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = { 2, 5, 7, 8, 1, 3, 4, 7, 1 };

        MergeSort<Integer> ms = new MergeSort<>();
        ms.sort(a);

        for (Integer num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
