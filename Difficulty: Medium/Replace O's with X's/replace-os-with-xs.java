class Solution {
    public void fill(char[][] grid) {
        // Code here
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean [][] vis = new boolean [rows][cols];
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        for(int row = 0; row < rows; row++){
            if(!vis[row][0] && grid[row][0] == 'O'){
                dfs(vis, grid, row, 0, drow, dcol);
            }
            
            if(!vis[row][cols - 1] && grid[row][cols - 1] == 'O'){
                dfs(vis, grid, row, cols - 1, drow, dcol);
            }
        }
        
        for(int col = 0; col < cols; col++){
            if(!vis[0][col] && grid[0][col] == 'O'){
                dfs(vis, grid, 0, col, drow, dcol);
            }
            
            if(!vis[rows - 1][col] && grid[rows - 1][col] == 'O'){
                dfs(vis, grid, rows - 1, col, drow, dcol);
            }
        }
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(!vis[row][col] && grid[row][col] == 'O'){
                    grid[row][col] = 'X';
                    vis[row][col] = true;
                }
            }
        }
    }
    
    public void dfs(boolean [][] vis, char[][] grid, int row, int col, int []drow, int dcol[]){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        
        if(grid[row][col] == 'X' || vis[row][col]) return ;
        vis[row][col] = true;
        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < grid.length && ncol >=0 && ncol <grid[0].length &&
            !vis[nrow][ncol] && grid[nrow][ncol] == 'O'){

                dfs(vis, grid, nrow, ncol, drow, dcol);
            }
        }
    }
}
