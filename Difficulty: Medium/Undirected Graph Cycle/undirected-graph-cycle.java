class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean []vis, int v){
        Pair s = new Pair(v, -1);
        Queue<Pair> q = new ArrayDeque<>();
        vis[v] = true;
        q.add(s);
        while(!q.isEmpty()){
            Pair c = q.poll();
            int curr = c.first;
            int par = c.second;
            
            for(int node: adj.get(curr)){
                if(!vis[node]){
                    vis[node] = true;
                    q.add(new Pair(node, curr));
                }else if(node != par){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean [] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i <edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i = 0; i <V; i++){
            if(!vis[i]){
                if(detectCycle(adj, vis, i)){
                    return true;
                }
            }
            
        }
        return false;
        
        
    }
}