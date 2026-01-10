// User function Template for Java

class Solution {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        
        int edge [][] = new int [n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(edge[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i< n; i++){
            edge[i][i] = 0;
        }
        for(int i = 0; i < m; i++){
            edge[edges[i][0]][edges[i][1]] = edges[i][2];
            edge[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int node = 0; node < n; node++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(edge[i][node] != Integer.MAX_VALUE && edge[node][j] != Integer.MAX_VALUE &&
                        edge[i][j] > edge[i][node] + edge[node][j]){
                        edge[i][j] = edge[i][node] + edge[node][j];
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(edge[i][j] <= distanceThreshold){
                    count++;
                }
            }
            
            if(count <= min){
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}
