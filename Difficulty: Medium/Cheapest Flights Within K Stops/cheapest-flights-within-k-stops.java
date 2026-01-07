class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Triple{
    int first;
    int second;
    int dist;
    
    public Triple(int first, int second, int dist){
        this.first = first;
        this.second = second;
        this.dist = dist;
    }
}

class Solution {

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int minCost [] = new int[n];
        int m = flights.length;
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int i = 0; i < m; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];
            
            adj.get(s).add(new Pair(d, c));
        }
        
        Queue<Triple> pq = new ArrayDeque<>();
        pq.add(new Triple(src, k, 0));
        
        while(!pq.isEmpty()){
            Triple p = pq.poll();
            
            int source = p.first;
            int cost = p.dist;
            int uk = p.second;
            if(uk < 0) continue;
            for(Pair ad: adj.get(source)){
                int dest = ad.first;
                int fare = ad.second;
                if((cost + fare < minCost[dest]) && uk >= 0){
                    minCost[dest] = cost + fare;
                    pq.add(new Triple(dest, uk - 1, minCost[dest]));
                }
            }
        }
        if(minCost[dst] == Integer.MAX_VALUE) return -1;
        return minCost[dst];
    }
}