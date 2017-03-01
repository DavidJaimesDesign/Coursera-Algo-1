import java.util.*;
import java.lang.*;
//import edu.princeton.cs.algs4.*;

public class Board {
    private final int N;
    private final int[][] data;
    
    public Board(int[][] blocks){           // construct a board from an n-by-n array of blocks
        this(blocks, 0);
    }                                       // (where blocks[i][j] = block in row i, column j)
    
    private Board(int[][] blocks, int moves){
        this.N = blocks.length;
        this.data = new int[N][N];
        
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                this.data[i][j] = blocks[i][j];
            }
        }
    } 
    public int dimension(){                 // board dimension n
        return N;
    }
    public int hamming(){                   // number of blocks out of place
        int num, hammingValue = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                num = i * N + j + 1;
                if(i == N-1 && j == N-1) break;
                if(data[i][j] != num) hammingValue++;
                num++;
            }
        }
        return hammingValue;
    }
    public int manhattan(){                 // sum of Manhattan distances between blocks and goal
        int manhattanValue = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(data[i][j] == 0) continue;
                int iTmp = (data[i][j]-1)/N;
                int jTmp = (data[i][j]-1)%N;
                manhattanValue += (Math.abs(iTmp - i) + Math.abs(jTmp -j));
            }
        }
        return manhattanValue;
    }
    public boolean isGoal(){                // is this board the goal board?
        int num = 1;
        if(data[N-1][N-1] != 0) return false;
     
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(data[i][j] == 0) break;
                if(data[i][j] != num) return false;
                num++;
            }
        }
        return true;
    }
    public Board twin(){                    // a board that is obtained by exchanging any pair of blocks
        Board bb = new Board(data);
        
        if(bb.data[0][0] == 0){
            exch(bb.data, 1, 0, 1, 1);
        } else if(bb.data[0][1] == 0){
            exch(bb.data, 1, 0, 1, 1);
        } else {
            exch(bb.data, 0,0,1,1);
        }
        return bb;            
    }
    public boolean equals(Object y){        // does this board equal y?
        if(y == null) return false;
        if(y == this) return false;
        
        if(y.getClass() != this.getClass()) return false;
        
        Board that = (Board) y;
        
        if(that.dimension() != this.dimension()) return false;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(this.data[i][j] != that.data[i][j]) return false;
            }
        }
        return true;
    }
    public Iterable<Board> neighbors() {    // all neighboring boards
        Stack<Board> stack = new Stack<Board>();
        
        int row = 0, col = 0;
        int[][] dataTmp = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j =0; j < N; j++){
                dataTmp[i][j] = data[i][j];
                if(data[i][j] == 0){
                    row = i;
                    col = j;
                }
            }
        }
        
        if (col > 0){
           exch(dataTmp, row, col, row, col-1);
           stack.push(new Board(dataTmp));
           exch(dataTmp, row, col, row, col-1);
        }
        
        if(col < N-1){
            exch(dataTmp, row, col, row, col+1);
            stack.push(new Board(dataTmp));
            exch(dataTmp, row, col, row, col+1);
        }
        
        if(row > 0){
            exch(dataTmp, row, col, row-1, col);
            stack.push(new Board(dataTmp));
            exch(dataTmp, row, col, row-1, col);
        }
        
        if(row < N-1){
            exch(dataTmp, row, col, row+1, col);
            stack.push(new Board(dataTmp));
            exch(dataTmp, row, col, row+1, col);
        }
        return stack;
    }
    
    private void exch(int[][] matrix, int i, int j, int p, int q){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }
    public String toString(){               // string representation of this board (in the output format specified below)
        StringBuilder str = new StringBuilder(dimension() + "\n");
        
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j++){
                str.append(data[i][j]);
                str.append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }
    //public static void main(String[] args) // unit tests (not graded)
}