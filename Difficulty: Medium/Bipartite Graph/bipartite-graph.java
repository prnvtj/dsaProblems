class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        
        int n = edges.length;
        
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            edge.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++){
            
            int r = edges[i][0];
            int c = edges[i][1];
            edge.get(r).add(c);
            edge.get(c).add(r);
        }
        
        int [] vis = new int [V];
        Arrays.fill(vis, -1);
        
        
        for(int i = 0; i < V; i++){
            if(vis[i] == -1){
                vis[i] = 0;
                if(!bfs(edge, vis, i)) return false;
            }
        }
        return true;
    }
    
    public boolean bfs (ArrayList<ArrayList<Integer>> edge, int [] vis, int p){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(p);
        
        while(!q.isEmpty()){
            int e = q.poll();
            
            for(int i: edge.get(e)){
                if(vis[i] == -1){
                    vis[i] = (vis[e] ^1);
                    q.add(i);
                }else{
                    if(vis[e] == vis[i]){
                        return false;
                    }
                }
            }
        }
        return true;
        
        
    }
}