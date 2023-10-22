import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int trials;
    private double[] thresholds;
    private double meanVal;
    private double stddevVal;
    private double confidenceLoVal;
    private double confidenceHiVal;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Invalid input(s).");
        }
        this.trials = trials;
        thresholds = new double[trials];

        for (int trial = 0; trial < trials; trial++) {
            Percolation percolation = new Percolation(n);
            int openSites = 0;

            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);

                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    openSites++;
                }
            }
            thresholds[trial] = (double) openSites / (n * n);
            findStatistics();
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return meanVal;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddevVal;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLoVal;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHiVal;
    }

    // a helper function
    private void findStatistics() {
        meanVal = StdStats.mean(thresholds);
        stddevVal = StdStats.stddev(thresholds);
        double confidenceFraction = 1.96 * stddevVal / Math.sqrt(trials);
        confidenceLoVal = meanVal - confidenceFraction;
        confidenceHiVal = meanVal + confidenceFraction;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);

        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}
