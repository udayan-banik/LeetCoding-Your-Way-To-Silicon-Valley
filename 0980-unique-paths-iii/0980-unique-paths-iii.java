class Solution {
    int count;
    public int uniquePathsIII(int[][] grid) {
        
        int row = grid.length, col = grid[0].length;
        int oneR = 0, oneC = 0;
        int zero = 0;
        count = 0;
        for(int r = 0; r < row;++r){
            for(int c = 0; c < col; ++c){
                if(grid[r][c] == 1){
                    oneR = r;
                    oneC = c;
                }else if(grid[r][c] == 0){
                    ++zero;
                }            
            }
        }
        
        backtrack(grid, oneR - 1, oneC, zero);
        backtrack(grid, oneR + 1, oneC, zero);
        backtrack(grid, oneR, oneC + 1, zero);
        backtrack(grid, oneR, oneC - 1, zero);
        
        return count;
    }
    
    public void backtrack(int[][] grid, int r, int c, int zero){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1 || grid[r][c] == 3 || grid[r][c] == 1)
            return;
        
        if(grid[r][c] == 2){
            if(zero == 0) ++count;
            return;
        }
        
        if(grid[r][c] == 0)
            --zero;
        
        grid[r][c] = 3;
        backtrack(grid, r + 1, c, zero);
        backtrack(grid, r - 1, c, zero);
        backtrack(grid, r, c - 1, zero);
        backtrack(grid, r, c + 1, zero);
        grid[r][c] = 0;
    }
}