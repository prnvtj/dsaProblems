class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis [] = new boolean[adj.size()];
        int n = adj.size();
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int ver = q.poll();
            ans.add(ver);
            
            for(int ad: adj.get(ver)){
                if(!vis[ad]){
                    vis[ad] = true;
                    q.add(ad);
                }
            }
        }
        return ans;
    }
}