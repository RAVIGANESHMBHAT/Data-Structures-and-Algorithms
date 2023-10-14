// Dynamic Connectivity problem
// union(1,2) -> add a path from node 1 to node 2
// union(2,3) -> add a path from node 2 to node 3
// isConnected(1,3) -> returns boolean whether from node 1 can we reach node 3

public class QuickUnionUF {
    private int[] ids;

    public QuickUnionUF(int n) {
        ids = new int[n];
        for(int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    private int root(int p) {
        while(p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }
}