// User function Template for Java
class Pair{
    int first; 
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        
        int dis [] = new int [V];
        Arrays.fill(dis, (int)1e8);
        dis[src] = 0;
        
        for(int node = 0; node <V -1; node++){
            
            for(int i = 0; i < edges.length; i++){
                
                int curr = edges[i][0];
                int nei = edges[i][1];
                int wt = edges[i][2];
                
                if(dis[curr] != 1e8 && dis[nei] > wt + dis[curr]){
                    dis[nei] = dis[curr] + wt;
                }
                
            }
        }
        int [] fail = {-1};
        
        for(int i = 0; i < edges.length; i++){
                
                int curr = edges[i][0];
                int nei = edges[i][1];
                int wt = edges[i][2];
                
                if(dis[curr] != 1e8 && dis[nei] > wt + dis[curr]){
                    return fail;
                }
                
        }
        return dis;
    }
}
