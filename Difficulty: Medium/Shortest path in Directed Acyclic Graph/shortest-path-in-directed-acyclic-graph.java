// User function Template for Java
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0; i < E; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        boolean vis [] = new boolean [V];
        Stack<Integer> st = new Stack<>();
        dfs(adj, vis, 0, st);
        int dis [] = new int [V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        
        while(!st.isEmpty()){
            int u = st.pop();
            
            for(Pair p: adj.get(u)){
                int v = p.first;
                int w = p.second;
                
                if(dis[u] + w < dis[v]){ // relaxation of edges
                    dis[v] = dis[u] + w;
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
        
    }
    
    public void dfs(ArrayList<ArrayList<Pair>> adj, boolean vis [], int src, Stack<Integer> st){
        
        vis[src] = true;
        
        for(Pair p: adj.get(src)){
            int v = p.first;
            if(!vis[v]){
                dfs(adj, vis, v, st);
                
            }
        }
        st.push(src);
    }
}