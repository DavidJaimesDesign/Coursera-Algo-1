import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
public class Percolation {
    private int n;
    private boolean[] grid;
    private WeightedQuickUnionUF wquf;
    private int bottom;
   
    public Percolation(int n) {               // create n-by-n grid, with all sites blocked
        this.n = n;
        this.grid = new boolean[n*n];
        this.wquf = new WeightedQuickUnionUF(n*n + 2);
        this.bottom = n * n + 1;
       
        for (int i = 0; i < n*n; i++) {
            this.grid[i] = false;
        }    
    }
   
    private void union(int i, int j)  {
        wquf.union(i, j);   
    }
    private int formatedCoords(int row,int col){
        int formatedCoords;
        int formatedRow = row - 1;
        int formatedColumn = col - 1;
        formatedCoords = (formatedRow * n) + formatedColumn;
        return formatedCoords;
    }
    
    private int getQFIndex(int row, int col){
        return (n * (row - 1) + col);
    }
    public    void open(int row, int col)  {    // open site (row, col) if it is not open already
        int pos = formatedCoords(row, col);
        grid[pos] = true;
        
        if (row == 1){
            this.union(getQFIndex(row, col), 0); 
        }
        
        if (row == n){
            this.union(getQFIndex(row, col), bottom);
        }
       
        if(col > 1 && isOpen(row, col-1)){
            this.union(getQFIndex(row,col),getQFIndex(row, col - 1));;
        }

        if(col < n && isOpen(row, col+1)){
            this.union(getQFIndex(row, col),getQFIndex(row, col + 1));;
        }

        if(row > 1 && isOpen(row - 1, col)){
            this.union(getQFIndex(row, col),getQFIndex(row -1, col));;
        }

        if(row < n &&isOpen(row + 1, col)){
            this.union(getQFIndex(row, col), getQFIndex(row + 1, col));
        }
    }
   
    public boolean isOpen(int row, int col)  {  // is site (row, col) open?
        return grid[formatedCoords(row, col)];
    }
    public boolean isFull(int row, int col) {  // is site (row, col) full?
        if(0 < row && row <= n && 0 < col && col <= n){
            return wquf.connected(0, getQFIndex(row, col));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }    
    public     int numberOfOpenSites() {       // number of open sites
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            if(grid[i] == true) count ++;
        }
        
        return count;
    }
    public boolean percolates() {              // does the system percolate?
        return wquf.connected(0, n * n + 1);
    }
    public static void main(String[] args) {   // test client (optional)
        // TODO   
    }
}