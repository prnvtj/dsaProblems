class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        // Code here
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean [][] vis = new boolean [rows][cols];
        boolean flag = false;
        Pair source = new Pair(0,0);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    source.first = i;
                    source.second = j;
                    vis[i][j] = true;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        
        return dfs(grid, vis, source, rows, cols);
        
    }
    
    public boolean dfs(int[][] grid, boolean [][] vis, Pair source, int rows, int cols){
        int r = source.first;
        int c = source.second;
        if(grid[r][c] == 2) return true;
        vis[r][c] = true;
        int [] drow = {-1, 0, 1, 0};
        int [] dcol = {0, 1, 0, -1};
        
        for(int i = 0; i < 4; i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            
            if(nrow >=0 && nrow < rows && ncol >=0 && ncol < cols &&
            !vis[nrow][ncol] && (grid[nrow][ncol] == 2 || grid[nrow][ncol] == 3)){
                
                if(dfs(grid, vis, new Pair(nrow, ncol), rows, cols)) return true;
            }
        }
        
        return false;
        
    }
}