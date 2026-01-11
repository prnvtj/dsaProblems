class Disjoint{
    int [] rank;
    int [] parent;
    int [] size;
    
    public Disjoint(int n){
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for(int i = 0; i <=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int findParent(int u){
        if(u == parent[u]) return u;
        
        return parent[u] = findParent(parent[u]);
    }
    
    void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        
        if(pu == pv) return;
        
        int newSize = size[pu] + size[pv];
        
        if(size[pu] > size[pv]){
            size[pu] += newSize;
            parent[pv] = pu;
        }else{
            size[pv] += newSize;
            parent[pu] = pv;
        }
    }
}

class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        int m = edge.length;
        if(m < n - 1){
            return -1;
        }
        
        Disjoint ds = new Disjoint(n);
        int comp = 0;
        int xtra = 0;
        for(int i = 0; i < m; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            int pu = ds.findParent(u);
            int pv = ds.findParent(v);
            
            if(pu != pv){
                ds.unionBySize(u, v);
            }else{
                xtra++;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) comp++;
        }
        
        if(xtra < comp - 1) return -1;
        
        return (comp -1);
        
        
    }
}