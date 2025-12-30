class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        boolean vis [] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(adj, vis, i, st);
            }
            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis [], int v, Stack<Integer> st){
        vis[v] = true;
        for(int i : adj.get(v)){
            if(!vis[i]){
                
                dfs(adj, vis, i, st);
            }
        }
        st.push(v);
    }
}