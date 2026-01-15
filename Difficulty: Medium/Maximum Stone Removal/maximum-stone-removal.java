class Disjoint{
    int size [];
    int parent [];
    public Disjoint(int n){
        size = new int [n+ 1];
        parent = new int [n + 1];
        
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i]= i;
        }
    }
    
    int findParent(int u){
        if (u == parent[u]) return u;
        
        return parent[u] = findParent(parent[u]);
    }
    
    void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        
        if(pu == pv) return;
        int newSize = size[pv] + size[pu];
        if(size[pv] > size[pu]){
            parent[pu] = pv;
            size[pv] = newSize;
        }else{
            parent[pv] = pu;
            size[pu] = newSize;
        }
    }
}

class Solution {
    int maxRemove(int[][] stones) {
        // Code here
        
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int [] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        int count = 0;
        Disjoint ds = new Disjoint(maxRow + maxCol + 1);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            
            ds.unionBySize(row, col);
            hm.put(row, 1);
            hm.put(col, 1);
        }
        
        Set<Integer> set = hm.keySet();
        
        for(Integer loc: set){
            if(ds.findParent(loc) == loc){
                count++;
            }
        }
        
        return n - count;
        
        
        
    }
};
