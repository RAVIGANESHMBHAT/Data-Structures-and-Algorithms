### Disjoint Set

- It is mainly used in the dynamic graphs( graph which keep on changing)
- It gives two functions
  - findParent()
  - union() [union by rank | union by size]

#### Pseudo-code for `Union(u,v)`

1. Find the ultimate parent of `u` and `v`, let say `pu` and `pv`
2. Find rank of those ultimate parents, i.e: parent of `pu` and `pv`.
3. Connect smaller rank to larger rank always

**Note:** Graphs use 1 based index

Initially, create 2 arrays,

`rank`

<table>
  <tr>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">0</td>
  </tr>
  <tr>
    <td style="text-align:center; width: 25px; height: 25px;">1</td>
    <td style="text-align:center; width: 25px; height: 25px;">2</td>
    <td style="text-align:center; width: 25px; height: 25px;">3</td>
    <td style="text-align:center; width: 25px; height: 25px;">4</td>
    <td style="text-align:center; width: 25px; height: 25px;">5</td>
    <td style="text-align:center; width: 25px; height: 25px;">6</td>
  </tr>
</table>

`parent`

<table>
  <tr>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">1</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">2</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">3</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">4</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">5</td>
    <td style="text-align:center; width: 25px; height: 25px; border: 1px solid grey;">6</td>
  </tr>
  <tr>
    <td style="text-align:center; width: 25px; height: 25px;">1</td>
    <td style="text-align:center; width: 25px; height: 25px;">2</td>
    <td style="text-align:center; width: 25px; height: 25px;">3</td>
    <td style="text-align:center; width: 25px; height: 25px;">4</td>
    <td style="text-align:center; width: 25px; height: 25px;">5</td>
    <td style="text-align:center; width: 25px; height: 25px;">6</td>
  </tr>
</table>

.
.
.

Time Complexity: `O(4α)` where α has a value closer to 1.
