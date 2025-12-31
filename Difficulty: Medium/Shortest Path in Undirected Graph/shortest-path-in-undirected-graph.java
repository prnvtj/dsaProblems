class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int [] dist = new int [V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        
        while(!q.isEmpty()){
            
            int u = q.poll();
            
            for(int v: adj.get(u)){
                if(dist[v] > (dist[u] + 1)){
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        
        for(int i = 0; i <V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
