class Solution {
    private int height;
    private int width;
    private int[][] dp;
    private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int uniquePathsIII(int[][] grid) {
        this.height = grid.length;
        this.width = grid[0].length;
        this.dp = new int[height * width][1 << (height * width)];
        int startX = -1, startY = -1;
        int state = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 0 || grid[i][j] == 2)
                    state |= (1 << (i * width) + j);
                else if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(grid, startX, startY, state);
    }
    private int dfs(int[][] grid, int row, int col, int state){
        if(dp[row * width + col][state] > 0) return dp[row * width + col][state];
        if(state == 0 && grid[row][col] == 2) return 1;
        int tx = 0, ty = 0;
        for(int d = 0; d < 4; d++){
            tx = row + dir[d][0];
            ty = col + dir[d][1];
            if(tx >= 0 && tx < height && ty >= 0 && ty < width && grid[tx][ty] != -1){
                if((state & (1 << (tx * width + ty))) == 0) continue;
                dp[row * width + col][state] += dfs(grid, tx, ty, state ^ (1 << (tx * width + ty)));
            }
        }
        return dp[row * width + col][state];
    }
}