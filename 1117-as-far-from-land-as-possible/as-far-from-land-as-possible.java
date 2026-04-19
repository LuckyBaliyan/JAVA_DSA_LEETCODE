class Solution {
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, -1, 0, 1};

    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean [n][n];
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                   q.offer(new int [] {i, j});
                   visited[i][j] = true;
                }
            }
        }

        //all are 1 so they all gonnna filled in there
        if(q.size() == n * n)return  -1;

        int cnt = -1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int [] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int x = 0; x<4; x++){
                    int nr =  r + dr[x];
                    int nc = c + dc[x];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n && 
                    !visited[nr][nc] && grid[nr][nc] == 0){
                        q.offer(new int [] {nr, nc, grid[nr][nc]});
                        visited[nr][nc] = true;
                    }
                }
            }

            cnt++;
        }

        return cnt;
    }
}