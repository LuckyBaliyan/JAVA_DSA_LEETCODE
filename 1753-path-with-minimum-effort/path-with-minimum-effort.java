class Solution {
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int []> pq = 
        new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        //sort on basis of effort i.e min

        int [][] path = new int [n][m];
        for(int [] p : path)Arrays.fill(p, Integer.MAX_VALUE);

        //add src in queue
        path[0][0] = 0;
        pq.offer(new int [] {0,0,0});

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(effort < path[r][c])continue;
            if(r == n-1 && c == m-1)return effort;

            for(int i = 0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m)continue;

                int diff = Math.abs(heights[nr][nc] - heights[r][c]);
                int maxEffort = Math.max(effort, diff);

                if(maxEffort < path[nr][nc]){
                    path[nr][nc] = maxEffort;
                    pq.offer(new int [] {maxEffort, nr, nc});
                }
            }
        }

        return path[n-1][m-1];
    }
}