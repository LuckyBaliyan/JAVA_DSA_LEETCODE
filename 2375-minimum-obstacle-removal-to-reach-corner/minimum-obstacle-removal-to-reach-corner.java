class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    public int minimumObstacles(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;

       PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->Integer.compare(
        a[0],b[0]
       ));

       int [][] path = new int[n][m];

       for(int [] arr:path)Arrays.fill(arr,Integer.MAX_VALUE);
       path[0][0] = grid[0][0];

       pq.offer(new int [] {path[0][0],0,0});

       while(!pq.isEmpty()){
           int [] p = pq.poll();
           int cost = p[0];
           int r = p[1];
           int c = p[2];
           
           if(cost > path[r][c])continue;
           if(r == n-1 && c == m-1)return cost;

           for(int i = 0;i<4;i++){
               int nr = r + dr[i];
               int nc = c + dc[i];

               if(nr >= 0 && nr < n && nc >=0 && nc < m){
                if(cost + grid[nr][nc] < path[nr][nc]){
                  path[nr][nc] = cost + grid[nr][nc];
                  pq.offer(new int [] {cost + grid[nr][nc],nr,nc});
               }     
               }
           }
       }

       return path[n-1][m-1];
    }
}