// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int rows = grid.length;
        int cols = grid[0].length;
        boolean vis [][] = new boolean[rows][cols];
        int [] drow = {-1, 0, 1, 0};
        int [] dcol = {0, 1, 0, -1};
        
        for(int row = 0; row < rows; row++){
            if(!vis[row][0] && grid[row][0] == 1){
                dfs(vis, grid, row, 0, drow, dcol);
            }
            
            if(!vis[row][cols - 1] && grid[row][cols - 1] == 1){
                dfs(vis, grid, row, cols - 1, drow, dcol);
            }
        }
        
        for(int col = 0; col < cols; col++){
            if(!vis[0][col] && grid[0][col] == 1){
                dfs(vis, grid, 0, col, drow, dcol);
            }
            
            if(!vis[rows - 1][col] && grid[rows - 1][col] == 1){
                dfs(vis, grid, rows - 1, col, drow, dcol);
            }
        }
        int ans = 0;
        for(int r = 1; r < rows - 1; r++){
            for(int c = 1; c < cols - 1; c++){
                if(!vis[r][c] && grid[r][c] == 1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    public void dfs(boolean [][] vis, int[][] grid, int row, int col, int []drow, int dcol[]){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        
        if(grid[row][col] == 0 || vis[row][col]) return ;
        vis[row][col] = true;
        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            dfs(vis, grid, nrow, ncol, drow, dcol);
        }
    }
}