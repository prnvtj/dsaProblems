class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public int countIslands(char[][] grid) {
        // Code here
        int rows = grid.length, cols = grid[0].length;
        boolean [][] vis = new boolean [rows][cols];
        int ans = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 'L' && !vis[row][col]){
                    vis[row][col] = true;
                    bfs(grid, vis, rows, cols, row, col);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void bfs(char[][] grid, boolean [][] vis, int rows, int cols, int row, int col){
        
        Pair curr = new Pair(row, col);
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(curr);
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            for(int i = -1; i <=1; i++){
                for(int j = -1; j <=1; j++){
                    int nrow = r + i;
                    int ncol = c + j;
                    if(nrow >=0 && nrow <rows && ncol >=0 && ncol <cols &&
                        grid[nrow][ncol] == 'L' && !vis[nrow][ncol]){
                        
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow, ncol));
                    }
                    
                }
            }
        }
    }
}