/*----------------------------------------------------------------
 *  Author:        David Jaimes
 *  Written:       01/27/2017
 *  Last updated:  01/27/2017
 *
 *  Compilation:   javac PercolationStats.java
 *  Execution:     java PercolationStats
 *
 *  Tests the percolation as per the specification available at:
 *    http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 *
 *----------------------------------------------------------------*/
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private int experimentsCount;
    private Percolation pr;
    private double[] fractions;
    public PercolationStats(int n, int t) {    // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException("Given n <= 0 || t <= 0");
        }
        experimentsCount = t;
        fractions = new double[experimentsCount];
        for (int expNum = 0; expNum < experimentsCount; expNum++) {
            pr = new Percolation(n);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (n * n);
            fractions[expNum] = fraction;
        }
    }
    public double mean() {                          // sample mean of percolation threshold
        return StdStats.mean(fractions);
    }
    public double stddev() {                      // sample standard deviation of percolation threshold
        return StdStats.stddev(fractions);
    }
    public double confidenceLo() {                  // low  endpoint of 95% confidence interval
        return mean() - ((1.96 * stddev()) / Math.sqrt(experimentsCount));
    }    
    public double confidenceHi() {                  // high endpoint of 95% confidence interval
        return mean() + ((1.96 * stddev()) / Math.sqrt(experimentsCount));
    }
    public static void main(String[] args) {       // test client (described below)  
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}