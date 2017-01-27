import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private array grid;
    public Percolation(int n)             // create n-by-n grid, with all sites blocked
   {
       int size = n * n;
       ufGrid = WeightedQuickUnionUF(size);
       Boolean[] genGrid = new boolean[size];
       for(int i = 0;i < size; i++);
           genGrid[i] = false;
       grid = genGrid;
   }
   
   private static double formatCoords(int row, int col)//changed 2d coordinated to 1d coordinates
   {
       int formatedCoords;
       int formatedRow = row - 1;
       int formatedColumn = col - 1;
       int rowLength = Math.sqrt(grid.length);
       formatedCoords = (formatedRow * rowLength) + formatedCol;
       if ( formatedCoords <= 0 || formatedCoords > grid.length) throw new IndexOutOfBoundsException("row index i out of bounds");
       return formatedCoords;
   }
   
   public    void open(int row, int col)    // open site (row, col) if it is not open already
   {
       int coord = formatCoords(row, col);
       grid[cord] = true;
   }
   public boolean isOpen(int row, int col) // is site (row, col) open?
   {
       int coord = formatedCoords(row, col);
       return grid[coord];
   }
   public boolean isFull(int row, int col) // is site (row, col) full?
   {
       int coord = formatedCoords(row, col);
       if(grid[coord]){
           return false;
       } else {
           return true;
       }
   }
   public     int numberOfOpenSites()      // number of open sites
   public boolean percolates()             // does the system percolate?

   public static void main(String[] args);   // test client (optional)
}