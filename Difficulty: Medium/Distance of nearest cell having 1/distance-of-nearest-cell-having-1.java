class Triple{
    int first;
    int second;
    int dist;
    
    public Triple(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean vis [][] = new boolean [rows][cols];
        int [][] dis = new int [rows][cols];
        Queue<Triple> ones = new ArrayDeque<>();
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    ones.add(new Triple(row, col, 0));
                    dis[row][col] = 0;
                    vis[row][col] = true;
                }
            }
        }
        bfs(grid, vis, dis, ones);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int c = 0; c < cols; c++){
                curr.add(dis[r][c]);
            }
            ans.add(curr);
        }
        return ans;
        
        
    }
    
    public void bfs (int[][] grid, boolean vis [][], int [][] dist, Queue<Triple> ones){
        
        int [] r = {-1, 0 , 1 , 0};
        int [] c = {0, 1, 0, -1};
        int rows = grid.length;
        int cols = grid[0].length;
        while(!ones.isEmpty()){
            
            Triple t = ones.poll();
            
            for(int i = 0; i < 4; i++){
                int nrow = t.first + r[i];
                int ncol = t.second + c[i];
                
                if(nrow >=0 && nrow <rows && ncol >=0 && ncol < cols &&
                !vis[nrow][ncol] && grid[nrow][ncol] == 0){
            
                    vis[nrow][ncol] = true;
                    int ndis = t.dist + 1;
                    dist[nrow][ncol] = ndis;
                    ones.add(new Triple(nrow, ncol, ndis));
                }
            }
        }
        
    }
}