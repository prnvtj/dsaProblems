class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        
        //if a vertex is part of cycle or is directed towards a cycle, it is not safe
        
        boolean [] vis = new boolean [V];
        boolean [] path = new boolean [V];
        boolean [] safe = new boolean [V];
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            edge.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            edge.get(edges[i][0]).add(edges[i][1]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(edge, vis, path, safe, i);
            }
        }
        
        for(int i = 0; i < V; i++){
            if(safe[i]) ans.add(i);
        }
        return ans;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> edge, boolean [] vis, boolean [] path, boolean [] safe, int v){
        
        vis[v] = true;
        path[v] = true;
        for(int i : edge.get(v)){
            if(!vis[i]){
                if(dfs(edge, vis, path, safe, i)){
                    
                    return true;
                }
            }
            else{
                if(path[i]){
                    
                    return true;
                }
            }
        }
        safe[v] = true;
        path[v] = false;
        return false;
    }
}