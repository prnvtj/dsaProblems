class Pair{
    int node;
    int dist;
    
    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i =0; i <=n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i= 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        int dis [] = new int [n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        int parent [] = new int[n +1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            int node = p.node;
            int dist = p.dist;
            
            for(int i = 0; i < adj.get(node).size();i++){
                int nd = adj.get(node).get(i).node;
                int ew = adj.get(node).get(i).dist;
                if(dist > dis[nd]) continue;
                if(dis[nd] > (dist + ew)){
                    parent[nd] = node;
                    dis[nd] = dist + ew;
                    pq.add(new Pair(nd, dis[nd]));
                }
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(dis[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        ans.add(n);
        int i = n;
        while(parent[i] != 0){
            ans.add(0, parent[i]);
            i = parent[i];
        }
        ans.add(0, dis[n]);
        return ans;
        
    }
}