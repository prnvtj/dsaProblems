// User function Template for Java

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

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if (grid[source[0]][source[1]] == 0 || 
            grid[destination[0]][destination[1]] == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int dis [] [] = new int [rows][cols];
        
        for(int i = 0; i < rows; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[source[0]][source[1]] = 0;
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.add(new Triple(source[0], source[1], 0));
        
        
        int drow [] = {0, -1, 0, 1};
        int dcol [] = {-1, 0, 1, 0};
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int row = t.first;
            int col = t.second;
            int dist = t.dist;
            
            for(int i = 0; i < 4; i++){
                
                int r = row + drow[i];
                int c = col + dcol[i];
                
                if(r >=0 && r < rows && c >=0 && c < cols &&
                grid[r][c] == 1){
                    if(dis[r][c] > dis[row][col] + 1){
                        dis[r][c] = dis[row][col] + 1;
                        pq.add(new Triple(r, c, dis[r][c]));
                    }
                }
            }
        }
        int ans = dis[destination[0]][destination[1]];
        if(ans == Integer.MAX_VALUE) return -1;
        
        return ans;
    }
}
