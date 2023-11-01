### Lease Frequently Used (LFU)

- get(key) -> get value of `key` if exists, Or else return -1
- put(key value) -> update the value of `key` if present, OR insert the key if not already present. When the cache is full, remove the least frequently used key. If there are multiple LFU keys, then remove the least recently used key.

To do dry run use below data,

size = 2

put(1, 10)
put(2, 20)
get(1)
put(3, 30)
get(2)
get(3)
put(4, 40)
get(1)
get(3)
get(4)

Used for implementation,
Map<frequency_int, list_dll> freqList;
Map<key, node> keyMap;
capacity = 0;
leastFreq = 0;
