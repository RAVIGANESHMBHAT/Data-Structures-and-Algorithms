### Stacks

#### Basic Operations
- push(item)
- pop()
- isEmpty()
- size()


Implementing the stack by using an array creates a fixed size stack.

We can also make it dynamic by copying the data from one array to another array and have an additional space and push the new data there. But it is not efficient as the computation is expensive.

Another approach is, if array is full, create a new array of twice the size, and copy items.
Here, the amortized cost of adding to a stack is,
`N + (2 + 4 + 8 + ... + N) ~ 3N.`

N -> 1 array access per push

(2 + 4 + 8 + ... + N) -> k array accesses to double to size k