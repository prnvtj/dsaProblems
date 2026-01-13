class Disjoint{
    int parent [];
    int size [];
    
    public Disjoint(int n){
        parent = new int[n];
        size = new int [n];
        
        for(int i = 0; i < n; i++){
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
    public boolean isValid(int row, int col, int rows, int cols){
        return row >=0 && row < rows && col >= 0 && col < cols;
    }
    public int MaxConnection(int grid[][]) {
        // Your code here
        int rows = grid.length;
        int cols = grid[0].length;
        Disjoint ds = new Disjoint(rows*cols);
         
         
        int [] dr = {0, -1, 0, 1};
        int [] dc = {1, 0, -1, 0};
         
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                int idx = r*cols + c;
                
                    if(grid[r][c] == 1) { 
                        for(int i = 0; i < 4; i++){
                            int row = r + dr[i];
                            int col = c + dc[i];
                             
                            if(!isValid(row, col, rows, cols)) continue;
                             
                            
                            if(grid[row][col] == 1){
                                int loc = row*cols + col;
                                ds.unionBySize(idx, loc);
                            }
                        }
                         
                    }
                
            }
        }
        
        int maxSize = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                
                if(grid[r][c] == 0){
                    HashSet<Integer> unique = new HashSet<>();
                    int idx = r*cols + c;
                    int idxP = ds.findParent(idx);
                   int newSize = 1;
                   for(int i = 0; i< 4; i++){
                       
                       int row = r + dr[i];
                       int col = c + dc[i];
                       
                       if(!isValid(row, col, rows, cols)) continue;
                       
                       
                       if(grid[row][col] == 1){
                           int loc = row*cols + col;
                        int locP = ds.findParent(loc);
                        if(unique.add(locP))
                           newSize += ds.size[locP];
                       }
                   }
                   
                   maxSize = Math.max(newSize, maxSize);
                }
            }
            
        }
        
        for(int i = 0; i < rows * cols; i++){
            if(ds.findParent(i) == i){
                maxSize = Math.max(maxSize, ds.size[i]);
            }
        }

        return maxSize;
    }
}