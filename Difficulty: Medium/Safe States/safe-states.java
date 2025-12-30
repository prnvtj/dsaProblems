class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        
        //if a vertex is part of cycle or is directed towards a cycle, it is not safe
        
        int [] safe = new int [V];
        
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            edge.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++){
            edge.get(edges[i][1]).add(edges[i][0]);
            safe[edges[i][0]]++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < V; i++){
            if(safe[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int v = q.poll();
            ans.add(v);
            for(int i: edge.get(v)){
                safe[i]--;
                if(safe[i] == 0){
                    q.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
}