class Pair{
    int node;
    int dist;
    
    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        int [] dis = new int [V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int dist = p.dist;
            int node = p.node;
            
            for(int n = 0; n < adj.get(node).size(); n++){
                int nd = adj.get(node).get(n).node;
                int wt = adj.get(node).get(n).dist;
                
                if(wt + dist < dis[nd]){
                    dis[nd] = wt + dist;
                    pq.add(new Pair(nd, dis[nd]));
                }
            }
        }
        return dis;
        
    }
}