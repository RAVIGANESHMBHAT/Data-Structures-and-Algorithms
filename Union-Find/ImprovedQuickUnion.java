// Dynamic Connectivity problem
// union(1,2) -> add a path from node 1 to node 2
// union(2,3) -> add a path from node 2 to node 3
// isConnected(1,3) -> returns boolean whether from node 1 can we reach node 3

class ImprovedQuickUnionUF {
    private int[] ids;
    private int[] sz;

    public ImprovedQuickUnionUF(int n) {
        ids = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 0;
        }
    }

    private int root(int p) {
        while(p != ids[p]) {
            // ids[p] = ids[ids[p]]; // Path compression
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
        if(i == j) return;
        if(sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        } else {
            ids[j] = i;
            sz[i] += sz[j];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World");
    }
}