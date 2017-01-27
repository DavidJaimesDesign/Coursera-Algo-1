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
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
   private int rowLen;
   private int total;
   private int runCount;
   private double results;
   
   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       if(n <= 0 || trials <= 0) throw new IllegalArgumentException("n or trials is <= 0");
       rowLen = N;
       
       int i = trials
       total = 0;
       runCount = 0;
       results = new double[trials];
       while(0 < i--){
           int c = monteCarloSimulation(N); //wait where is this imported?
           results[i] = (double) c/n/n;
           total += c;
           runCount++;
       }
   }
   
   private in monteCarloSimulation(int N)
   {
       int c = 0;
       Percolation p = new Percolation(N)
       while(!p.percolates()){
           int i = 1 + StdRandom.uniform(N);
           int j = 1 + StdRandom.uniform(N);
           if(!p.isOpen(i, j)){
               c++;
               p.open(i, j);
           }
       }
       
       return c
   }
   public double mean()                          // sample mean of percolation threshold
   {
       return (double) total/runCount/rowLen/rowLen
   }
   public double stddev()                        // sample standard deviation of percolation threshold
   {
       if(1 == runCount) {
           return Double.NaN;
       }
       
       return StdStats.stddev(results)
   }
   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {
       //TODO   
       return 2;
   }
   public double confidenceHi()                  // high endpoint of 95% confidence interval
   {
       //TODO
       return 2;
   }
   public static void main(String[] args)       // test client (described below)
   {
       //TODO
       return 3;
   }
}
