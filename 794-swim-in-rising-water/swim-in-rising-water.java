class Solution {
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0, -1, 0, 1};

    public int swimInWater(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;

        PriorityQueue<int []> pq = 
        new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int [][] path = new int [n][m];
        for(int [] p: path)Arrays.fill(p, Integer.MAX_VALUE);

        //addd source cell
        path[0][0] = grid[0][0];
        pq.offer(new int [] {grid[0][0],0,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int time = curr[0];
            int  r = curr[1];
            int  c = curr[2];

            if(time > path[r][c])continue;
            if(r == n-1 && c == m-1)return time;

            for(int i = 0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >=n || nc < 0 || nc >=m)continue;
                
                int maxTime = Math.max(time, grid[nr][nc]);
                if(maxTime < path[nr][nc]){
                    path[nr][nc] = maxTime;
                    pq.offer(new int [] {maxTime, nr, nc});
                }
            }
        }

        return path[n-1][m-1];
    }
}