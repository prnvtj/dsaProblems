class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //on the same path, node has to be visited again
        //use two visited arrays: one is normal and another is path visited (this is backtraked)
        
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            edge.add(new ArrayList<Integer>());
        }
        boolean vis [] = new boolean [V];
        boolean path [] = new boolean [V];
        for(int i = 0; i < edges.length; i++){
            edge.get(edges[i][0]).add(edges[i][1]);
        }
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(edge, vis, path, i)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> edge, boolean vis [], boolean path [], int e){
        
       
        vis[e] = true;
        path[e] = true;
        
        
        for(int i: edge.get(e)){
            if(!vis[i]){
                if(dfs(edge, vis, path, i)) return true;
                
            }else{
                if(path[i]) return true;
            }
        }
        path[e] = false;
        return false;
    }
}