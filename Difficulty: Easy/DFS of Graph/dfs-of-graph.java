class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = 0;
        boolean vis [] = new boolean[adj.size()];
        dfs(adj, n, vis, ans);
        return ans;
        
    }
    
    public void dfs (ArrayList<ArrayList<Integer>> adj, int n, boolean [] vis, ArrayList<Integer> ans){
        
        vis[n] = true;
        ans.add(n);
        
        for(int num : adj.get(n)){
            if(!vis[num]){
                dfs(adj, num, vis, ans);
            }
        }
    }
}