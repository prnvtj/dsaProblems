class Triple{
    int first;
    int second;
    int steps;
    
    public Triple(int first, int second, int steps){
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}
class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        
        int [][] chess = new int [n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(chess[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((x, y) -> x.steps - y.steps);
        chess[knightPos[0] -1][knightPos[1] - 1] = 0;
        pq.add(new Triple(knightPos[0] -1, knightPos[1] - 1, 0));
        int [] dr = {1, 2, -1, -2, -1, -2, 1, 2};
        int [] dc = {2, 1, -2, -1, 2, 1, -2, -1};
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int x = t.first;
            int y = t.second;
            int s = t.steps;
            if((x == targetPos[0] - 1) && (y == targetPos[1] - 1)) continue;
            for(int i = 0; i < 8; i++){
                
                int r = x + dr[i];
                int c = y + dc[i];
                if(r >= 0 && r < n && c >= 0 && c < n){
                    if(chess[r][c] > chess[x][y] + 1){
                        chess[r][c] = chess[x][y] + 1;
                        pq.add(new Triple(r, c, chess[r][c]));
                    }
                }
                
            }
        }
        
        return chess[targetPos[0] - 1][targetPos[1] - 1];
        
    }
}