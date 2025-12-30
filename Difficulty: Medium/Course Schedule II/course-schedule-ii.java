class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        int ind [] = new int[n];
        ArrayList<Integer> course = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ind[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            
            if(ind[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int v = q.poll();
            course.add(v);
            for(int i : adj.get(v)){
                ind[i]--;
                if(ind[i] == 0){
                    q.add(i);
                }
            }
        }
        
        return course;
    }
}