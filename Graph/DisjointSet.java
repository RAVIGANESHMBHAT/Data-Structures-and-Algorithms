import java.util.Arrays;

class DisjointSet_UnionByRank {
    private int[] rank;
    private int[] parent;

    public DisjointSet_UnionByRank(int n) {
        rank = new int[n + 1];
        Arrays.fill(rank, 0);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }

    void unionByRank(int u, int v) {
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        if (ultimateParentOfU == ultimateParentOfV) {
            return;
        }
        if (rank[ultimateParentOfU] < rank[ultimateParentOfV]) {
            parent[ultimateParentOfU] = ultimateParentOfV;
        } else if (rank[ultimateParentOfV] < rank[ultimateParentOfU]) {
            parent[ultimateParentOfV] = ultimateParentOfU;
        } else {
            parent[ultimateParentOfV] = ultimateParentOfU;
            rank[ultimateParentOfU]++;
        }
    }
}

class DisjointSet_UnionBySize {
    private int[] size;
    private int[] parent;

    public DisjointSet_UnionBySize(int n) {
        size = new int[n + 1];
        Arrays.fill(size, 1);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }

    void unionBySize(int u, int v) {
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        if (ultimateParentOfU == ultimateParentOfV) {
            return;
        }
        if (size[ultimateParentOfU] < size[ultimateParentOfV]) {
            parent[ultimateParentOfU] = ultimateParentOfV;
            size[ultimateParentOfV] += size[ultimateParentOfU];
        } else {
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfU] += size[ultimateParentOfV];
        }
    }
}

public class DisjointSet {

    public static void main(String[] args) {
        DisjointSet_UnionByRank ds = new DisjointSet_UnionByRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        System.out.println("Union by rank:");

        System.out.println(ds.findUltimateParent(1) == ds.findUltimateParent(7));

        ds.unionByRank(3, 7);

        System.out.println(ds.findUltimateParent(3) == ds.findUltimateParent(7));

        // ---------------- //

        DisjointSet_UnionBySize ds_size = new DisjointSet_UnionBySize(7);
        ds_size.unionBySize(1, 2);
        ds_size.unionBySize(2, 3);
        ds_size.unionBySize(4, 5);
        ds_size.unionBySize(6, 7);
        ds_size.unionBySize(5, 6);

        System.out.println("Union by size:");

        System.out.println(ds_size.findUltimateParent(1) == ds_size.findUltimateParent(7));

        ds_size.unionBySize(3, 7);

        System.out.println(ds_size.findUltimateParent(3) == ds_size.findUltimateParent(7));
    }
}