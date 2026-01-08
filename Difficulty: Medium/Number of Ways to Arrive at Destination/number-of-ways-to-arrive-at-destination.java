class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Triple{
    int first;
    int second;
    int dist;
    
    public Triple(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        if(V == 1) return 1;
        int rows = edges.length;
        int cols = edges[0].length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int [] dis = new int [V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        long [] ways = new long [V];
        ways[0] = 1; dis[0] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);
        pq.add(new Pair(0, dis[0]));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int s = p.first;
            int d = p.second;
            if(d > dis[s]) continue;
            for(Pair ad: adj.get(s)){
                int node = ad.first;
                int wt = ad.second;
                
                if(d + wt == dis[node]){
                    ways[node] = (ways[node] + ways[s])%1000000007;
                }else if(d + wt < dis[node]){
                    ways[node] = ways[s];
                    dis[node] = d + wt;
                    pq.add(new Pair(node, dis[node]));
                }
                
            }
        }
        
        return (int)ways[V-1];
        
    }
}
