class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //on the same path, node has to be visited again
        //use two visited arrays: one is normal and another is path visited (this is backtraked)
        
        //another way - use toplogical sort
        
        int ind [] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            ind[edges[i][1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++){
            
            if(ind[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int v = q.poll();
            count++;
            for(int i : adj.get(v)){
                ind[i]--;
                if(ind[i] == 0){
                    q.add(i);
                }
            }
        }
        
        return (!(count == V));
    }
    
}