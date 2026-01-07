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
    public int minCostPath(int[][] mat) {
        // code here
        
        int rows = mat.length;
        int cols = mat[0].length;
        int [][] dis = new int [rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        dis[0][0] = 0;
        pq.add(new Triple(0, 0, 0));
        
        int [] dr = {0, -1, 0, 1};
        int [] dc = {1, 0, -1, 0};
        int ans = 0;
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int x = t.first;
            int y = t.second;
            int d = t.dist;
            
            if((x == rows - 1) && (y == cols - 1)){
                ans = d;
                break;
            } 
            int maxDist = d;
            for(int i = 0; i < 4; i++){
                int r = x + dr[i];
                int c = y + dc[i];
                if(r >= 0 && r < rows && c >= 0 && c < cols){
                    int dist = Math.max(d, Math.abs(mat[r][c]- mat[x][y]));
                    
                    if(dis[r][c] > dist){
                        dis[r][c] = dist;
                        pq.add(new Triple(r, c, dis[r][c]));
                    }
                    
                }
                
            }
        }
        
        return ans;
    }
}
