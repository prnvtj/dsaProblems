// User function Template for Java
class Disjoint{
    int [] parent;
    int [] size;
    
    public Disjoint (int n){
        parent = new int [n];
        size = new int [n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
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
            parent[pv] = pu;
            size[pu] = newSize;
        }else{
            parent[pu] = pv;
            size[pv] = newSize;
        }
    }
}

class Solution {
    
    public boolean isValid(int row, int col, int rows, int cols){
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        
        
        int [][] earth = new int[rows][cols];
        
        int count = 0;
        
        Disjoint ds = new Disjoint(rows*cols);
        int opLen = operators.length;
        int [] dr = {0, -1, 0, 1};
        int [] dc = {1, 0, -1, 0};
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < opLen; i++){
            
            int r = operators[i][0];
            int c = operators[i][1];
            
            if(earth[r][c] == 1){
                ans.add(count);
                continue;
            }
            earth[r][c] = 1;
            count++;
            int idx = r*cols + c;
            
            for(int s = 0; s < 4; s++){
                
                int row = r + dr[s];
                int col = c + dc[s];
                if(!isValid(row, col, rows, cols)) continue;
                if(earth[row][col] == 1){
                    
                    int loc = row*cols + col;
                    int locP = ds.findParent(loc);
                    int idxP = ds.findParent(idx);
                    if(locP != idxP){
                        ds.unionBySize(locP, idxP);
                        count--;
                    }
                }
                
                
            }
            ans.add(count);
            
        }
        return ans;
    }
}