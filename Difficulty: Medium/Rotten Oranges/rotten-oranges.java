class Triple{
    int first;
    int second;
    int third;
    
    public Triple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int orangesRot(int[][] mat) {
        // code here
        int ans = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        boolean vis [][] = new boolean[rows][cols];
        Queue<Triple> q = new ArrayDeque<>();
        
        for(int row = 0; row< rows; row++){
            for(int col = 0; col < cols; col++){
                if(mat[row][col] == 2){
                    vis[row][col] = true;
                    q.add(new Triple(row, col, 0));
                }
            }
        }
        
        int [] r = {-1, 0, 1, 0};
        int [] c = {0, -1, 0, 1};
        
        while(!q.isEmpty()){
            Triple p = q.poll();
            int row = p.first;
            int col = p.second;
            int t = p.third;
            for(int i = 0; i < 4; i++){
                
                int nrow = row + r[i];
                int ncol = col + c[i];
                
                if(nrow >=0 && ncol >=0 && nrow <rows && ncol < cols
                && !vis[nrow][ncol] && mat[nrow][ncol] == 1){
                    mat[nrow][ncol] = 2;
                    vis[nrow][ncol] = true;
                    q.add(new Triple(nrow, ncol, t+1));
                    ans = Math.max(ans, t+1);
                }
                    
            }
        }
        boolean flag = false;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col <cols; col++){
                if(mat[row][col] == 1){
                    flag = true;
                    break;
                }
            }
            if(flag){
                ans = -1;
                break;
            }
        }
        return ans;
    }
}