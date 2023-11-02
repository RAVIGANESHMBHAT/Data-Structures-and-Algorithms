package Sorting_Algorithms;

public class SelectionSort {
    Integer[] arr;

    SelectionSort(int n) {
        arr = new Integer[n];
    }

    public void insert(int index, int val) {
        if (index >= 0 && index < arr.length) {
            arr[index] = val;
        } else {
            System.out.println("Invalid index");
        }
    }

    public int size() {
        return arr.length;
    }

    void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    void selectionSort() {
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrLen; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(i, minIndex);
            }
        }
        // for (int i = 0; i < arrLen - 1; i++) {
        // int minIndex = i;
        // for (int j = i + 1; j < arrLen; j++) {
        // if (arr[j] < arr[minIndex]) {
        // minIndex = j;
        // }
        // }
        // if (minIndex != i) {
        // swap(i, minIndex);
        // }
        // }
    }

    public void print() {
        int len = size();

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort(5);
        ss.insert(0, 10);
        ss.insert(1, 4);
        ss.insert(2, 1);
        ss.insert(3, 3);
        ss.insert(4, 11);

        ss.print();

        ss.selectionSort();

        ss.print();

    }
}
