// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean [] vis = new boolean [V];
        int ans = 0;
        for(int i = 0; i <V; i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(adj, i, V, vis);
                ans++;
            }
            
        }
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int V, boolean [] vis){
        
            for(int j = 0; j < V; j++){
                if( i!=j && adj.get(i).get(j) == 1){
                    if(!vis[j]){
                        vis[j] = true;
                        dfs(adj, j, V, vis);
                    }
                }
            }
    }
}