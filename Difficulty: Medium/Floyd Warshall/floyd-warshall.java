// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        /* For everynode consider it as the intermediate node to move to a different node
        example if you want to move from 1 to 4 via 0:
        calculate dis[1][4] = dis[1][0] + dis[0][4];
        if one of the distance is infinite, then that path is not possible and we can 
        ignore updating it
        */
        
        int n = dist.length;
        for(int node = 0; node < n; node++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if((dist[i][node] != 1e8 && dist[node][j] != 1e8) && dist[i][j] > dist[i][node] + dist[node][j]){
                        dist[i][j] = dist[i][node] + dist[node][j];
                    }
                }
            }
        }
    }
}