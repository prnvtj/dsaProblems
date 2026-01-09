class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int rows = mat.length;
        int cols = mat[0].length;
    
        
        ArrayList<Pair> al = new ArrayList<>();
        
        char c = word.charAt(0);
        for(int i = 0; i <rows; i++){
            for(int j = 0; j < cols; j++){
                if(c == mat[i][j]){
                    al.add(new Pair(i, j));
                }
            }
        }
        if(al.size() == 0) return false;
        
        for(Pair p: al){
            int x = p.first;
            int y = p.second;
            boolean [][] vis = new boolean [rows][cols];
            if(dfs(mat, word, x, y, 0, vis)) return true;
        }
        
        return false;
    }
    
    public boolean dfs(char[][] mat, String word, int x, int y, int k, boolean [][] vis){
        
        int rows = mat.length;
        int cols = mat[0].length;
        if(x < 0 || x >= rows || y < 0 || y >= cols) return false;
        if(mat[x][y] != word.charAt(k)) return false;
        if(vis[x][y]) return false;
        if(k == word.length() - 1) return true;
        
        vis[x][y] = true;
        
        int dr [] = {0, -1, 0, 1};
        int dc [] = {1, 0, -1, 0};
        
        for(int i = 0; i < 4; i++){
                int r = x + dr[i];
                int c = y + dc[i];
                
                if(dfs(mat, word, r, c, k + 1, vis)) return true;
        }
        vis[x][y] = false;
        return false;
    }
}