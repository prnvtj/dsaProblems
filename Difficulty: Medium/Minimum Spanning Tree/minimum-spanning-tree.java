class Triple{
    int first;
    int second;
    int third;
    
    public Triple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Pair>());
        }
        boolean vis[] = new boolean [V];
        long min = 0;
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Triple> pq = new PriorityQueue<>((x, y) -> x.third - y.third);
        
        pq.add(new Triple(0, -1, 0));
        
        while(!pq.isEmpty()){
            Triple edge = pq.poll();
            int node = edge.first;
            int parent = edge.second;
            int wt = edge.third;
            
            if(vis[node]) continue;
                vis[node] = true;
            min += wt;
            for(Pair p: adj.get(node)){
                int adjNode = p.first;
                int edWt = p.second;
                if(!vis[adjNode])
                pq.add(new Triple(adjNode, node, edWt));
                
            }
            
        }
        return (int)min;
    }
}
