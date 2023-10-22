import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] sitesGrid;
    private int n;
    private int openSites;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n value should be greater than 0.");
        }
        this.n = n;
        sitesGrid = new boolean[n][n];
        openSites = 0;
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateRowAndCol(row, col);
        if (!isOpen(row, col)) {
            sitesGrid[row - 1][col - 1] = true;
            openSites++;
            int siteIndex = (row - 1) * n + col;
            int top = siteIndex - n;
            int bottom = siteIndex + n;

            if (row == 1) {
                uf.union(siteIndex, 0);
            }
            if (row == n) {
                uf.union(siteIndex, n * n + 1);
            }
            if (row > 1 && isOpen(row - 1, col)) {
                uf.union(siteIndex, top);
            }
            if (row < n && isOpen(row + 1, col)) {
                uf.union(siteIndex, bottom);
            }
            if (col > 1 && isOpen(row, col - 1)) {
                uf.union(siteIndex, siteIndex - 1);
            }
            if (col < n && isOpen(row, col + 1)) {
                uf.union(siteIndex, siteIndex + 1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRowAndCol(row, col);
        return sitesGrid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRowAndCol(row, col);
        int siteIdx = (row - 1) * n + col;
        return uf.find(siteIdx) == uf.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(0) == uf.find(n * n + 1);
    }

    private void validateRowAndCol(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("Row OR column index is out of range.");
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}

