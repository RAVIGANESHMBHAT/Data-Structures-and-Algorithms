We can implement to sort different values by modifying te compareTo method
Eg: sorting Integer, Double, String, Date, File etc.

![Alt text](<Screenshot from 2023-11-02 05-41-23.png>)

## Selection Sort
- In iteration `i`, find index `min` of smallest remaining entry.
- Swap `a[i]` and `a[min]`

__Time complexity__: `O(n^2)`

__Running time insensitive to input :__ Quadratic time, even if input is sorted.

__Data movement is minimal :__ Linear number of exchanges.


## Insertion Sort
- In iteration `i`, swap `a[i]` with each larger entry to it's left.

If the array is already sorted, then it doesn't do swapping in any case and it is faster than selection sort.

If the array is in descending order, then it is the worst case.

__Time complexity__: `O(n^2)` in worst case and `O(n)` in best case.

__Proposition :__ For partially-sorted array, insertion sort runs in linear time.
__Proof :__ Number of exchanges equals the number of inversions.


## Shell Sort
Move entries more than one position at a time by h-sorting the array.

It is inserting sort with stride length `h`.

In simple, create multiple groups sequentially of length h, and apply insertion sort to each group.

__Time complexity__: O(n<sup>3/2</sup>)  in worst case when `h=3X+1`.


## Merge Sort

#### Basic Plan
- Divide array into two halves
- Recursively split each half
- Merge two halves

![Alt text](<Screenshot from 2023-11-05 17-21-03.png>)

#### Time Complexity Analysis
Proposition: Merge Sort uses at most `N lgN` compares and `6N lgN` array assertions to sort any array of size `N`.

__Time Complexity__ = `N lgN`.

An extra `N size array` is needed to store the aux array.
To optimize this, we need to use in-place merge. But it is difficult.(Yet to come up with optimum approach)

![Alt text](<Screenshot from 2023-11-05 17-27-35.png>)


#### Merge Sort Practical Improvements
- Use insertion sort for sorting smaller sub-arrays
    * Mergesort has too much overhead for tiny sub-arrays
```java
private void sortHelper(T[] a, T[] aux, int lo, int hi) {
    // added the below if condition for optimization
    if (hi <= lo + CUTOFF - 1) {
        Insertion.sort(a, lo, hi);
        return;
    }

    int mid = lo + (hi - lo) / 2;

    sortHelper(a, aux, lo, mid);
    sortHelper(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
}
```

- Add the below condition in the sort() function to check if the a[mid+1] > a[mid], then the array is already sorted.a

EG:

```java
private void sortHelper(T[] a, T[] aux, int lo, int hi) {
    if (hi <= lo) {
        return;
    }

    int mid = lo + (hi - lo) / 2;

    sortHelper(a, aux, lo, mid);
    sortHelper(a, aux, mid + 1, hi);

    // added the below if condition for optimization
    if(!less(a[mid+1], a[mid])) {
        return;
    }
    merge(a, aux, lo, mid, hi);
}
```

![Alt text](<Screenshot from 2023-11-05 20-41-54.png>)
