class Solution {
    public int minPathSum(int[][] grid) {
        helper(0,0,grid);
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void helper(int r, int c, int grid[][]){
        if(r>=grid.length || c>=grid[0].length)return ;

        if(r!=0 && c!=0){
            grid[r][c]+= Math.min(grid[r-1][c], grid[r][c-1]);
        }
        for(int i=r+1; i<grid.length; i++){
            if(c==0)
            grid[i][c]+=grid[i-1][c];
            else 
            grid[i][c]+=Math.min(grid[i-1][c],grid[i][c-1]);
        }

        for(int i=c+1; i<grid[0].length; i++){
            if(r==0)
            grid[r][i]+=grid[r][i-1];
            else 
            grid[r][i]+=Math.min(grid[r][i-1],grid[r-1][i]);
        }

        helper(r+1,c+1,grid);
    }
}