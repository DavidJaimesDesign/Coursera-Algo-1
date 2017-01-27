import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private boolean[] grid;
    private WeightedQuickUnionUF wquf;
   
    public Percolation(int n) {               // create n-by-n grid, with all sites blocked
        this.n = n;
        this.grid = new boolean[n*n];
        this.wquf = new WeightedQuickUnionUF(n*n + 2);
       
        for (int i = 0; i < n*n; i++) {
            this.grid[i] = false;
        }    
    }
   
    private void union(int i, int j)  {
        wquf.union(i, j);   
    }
   
    public    void open(int row, int col)  {    // open site (row, col) if it is not open already
        int pos = (row * n) + col;
        if (!isOpen(row, col)) {
            grid[pos] = true;
       
           // check for open adjacent grid positions;
            if (row > 0) { // row above
                if (isOpen(row-1, col)) {
                    this.union(pos + 1, pos-n + 1);
                }
            } 
            else { // on the top we union with the top virtual element
                this.union(0, pos + 1);
            }
       
            if (row < n-1) { // row below
                if (isOpen(row+1, col)) {
                    this.union(pos + 1, pos+n + 1);
                }
            } 
            else { // on the bottom, we union with the bottom virtual element
                this.union(n*n+1, pos+1);
            }
       
            if (col > 0 && isOpen(row, col-1)) { // column to the left
                this.union(pos + 1, pos-1 + 1);
            }
       
            if (col < n-1 && isOpen(row, col+1)) { // column to the right
                this.union(pos + 1, pos+1 + 1);
            } 
        }
    }
   
    public boolean isOpen(int row, int col)  {  // is site (row, col) open?
   
        return !isFull(row, col);
    }
    public boolean isFull(int row, int col) {  // is site (row, col) full?
        return !grid[row * n + col];
    }    
    public     int numberOfOpenSites() {       // number of open sites
        // TODO
        return 4;
    }
    public boolean percolates() {              // does the system percolate?
        return wquf.connected(0, n * n + 1);
    }
    public static void main(String[] args) {   // test client (optional)
        // TODO   
    }
}