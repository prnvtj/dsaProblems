class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        int color = image[sr][sc];
        if(newColor == color){
            return image;
        }
        image[sr][sc] = newColor;
        bfs(image, sr, sc, newColor, color);
        return image;
    }
    
    public void bfs(int[][] image, int sr, int sc, int newColor, int color){
        
        int rows = image.length;
        int cols = image[0].length;
        Pair curr = new Pair(sr, sc);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(curr);
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            if(row + 1 < rows && col <cols && image[row +1][col] == color){
                image[row+1][col] = newColor;
                
                q.add(new Pair(row+1, col));
            }
            if(row < rows && col + 1 <cols && image[row][col +1] == color){
                image[row][col +1] = newColor;
                q.add(new Pair(row, col + 1));
            }
            if(row - 1 >= 0 && col <cols && image[row - 1][col] == color){
                image[row - 1][col] = newColor;
                q.add(new Pair(row-1, col));
            }
            if(row < rows && col - 1 >=0 && image[row][col - 1] == color){
                image[row][col - 1] = newColor;
                q.add(new Pair(row, col -1));
            }
        }
    }
}