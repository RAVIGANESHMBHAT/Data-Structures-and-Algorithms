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

__Proposition :__ For partially-sorted array, insertion sort runs in linear time.
__Proof :__ Number of exchanges equals the number of inversions.