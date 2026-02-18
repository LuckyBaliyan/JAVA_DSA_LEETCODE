class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1}; 
    static class Pair{
        int cost;
        int r;
        int c;

        Pair(int cost,int r,int c){
            this.cost = cost;
            this.r = r;
            this.c = c;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Pair> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        int [][] time = new int [n][n];
        for(int [] arr:time)Arrays.fill(arr,Integer.MAX_VALUE);

       // not necessarly to start with zero time[0][0] = grid[0][0];
       time[0][0] = grid[0][0];
        pq.offer(new Pair(grid[0][0],0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int cost = p.cost;
            int r = p.r;
            int c = p.c;

            if(cost > time[r][c])continue;
            if(r == n-1 && c == m-1)return cost;

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m)continue;
                int newCost = Math.max(cost, grid[nr][nc]);
                
                if(newCost < time[nr][nc]){
                    pq.offer(new Pair(newCost,nr,nc));
                    time[nr][nc] = newCost;
                }
            }
        }
        
        return time[n-1][n-1];
    }
}