// User function Template for Java

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        
        //just use topological sort and if P == topo.length then it is possible else not
        //tip: draw the graph first and then decide how to use topo sort
        int ind [] = new int[N];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < P; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ind[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < N; i++){
            
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
        
        return ((count == N));
    }
}