class Solution{
    static int [] dr = {-1,1,0,0};
    static int [] dc =  {0,0,-1,1};
    public int minimumEffortPath(int [][] heights){
       int n = heights.length;
       int m = heights[0].length;
       PriorityQueue<int[]> q = new 
       PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

       int [][] min = new int [n][m];
       for(int [] arr:min)Arrays.fill(arr,Integer.MAX_VALUE);
       min[0][0] = 0;

       q.offer(new int [] {0,0,0});

       while(!q.isEmpty()){
        int [] curr = q.poll();
        int effort = curr[0];
        int r = curr[1];
        int c = curr[2];

        if(effort > min[r][c])continue;

        if(r == n-1 && c == m-1)return effort;

        for(int i = 0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= m)continue;

            int diff = Math.abs(heights[r][c] - heights[nr][nc]);
            int maxEffort = Math.max(effort,diff);

            if(maxEffort < min[nr][nc]){
              min[nr][nc] = maxEffort;
              q.offer(new int [] {maxEffort, nr, nc});
            }
        }
       }

       return min[n-1][m-1];
    }
}