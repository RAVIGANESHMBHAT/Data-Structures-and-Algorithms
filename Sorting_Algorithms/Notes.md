We can implement to sort different values by modifying te compareTo method
Eg: sorting Integer, Double, String, Date, File etc.

![Alt text](<Screenshot from 2023-11-02 05-41-23.png>)

## Selection Sort
- In iteration `i`, find index `min` of smallest remaining entry.
- Swap `a[i]` and `a[min]`

__Time complexity__: `O(n^2)`

__Running time insensitive to input :__ Quadratic time, even if input is sorted.

__Data movement is minimal :__ Linear number of exchanges.