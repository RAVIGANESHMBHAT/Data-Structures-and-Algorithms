// Dynamic Connectivity problem
// union(1,2) -> add a path from node 1 to node 2
// union(2,3) -> add a path from node 2 to node 3
// isConnected(1,3) -> returns boolean whether from node 1 can we reach node 3

public class QuickFind {
    private int[] ids;

    public QuickFind(int n) {
        ids = new int[n];
        for(int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for(int i = 0; i< ids.length; i++) {
            if(ids[i] == pid) {
                ids[i] = qid;
            }
        }
    }
}