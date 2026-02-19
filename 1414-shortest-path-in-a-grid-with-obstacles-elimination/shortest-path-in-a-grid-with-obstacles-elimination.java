class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int []> q = new LinkedList<>();
        boolean [][][] visited = new boolean [n][m][k+1];

        visited[0][0][0] = true;
        q.offer(new int [] {0,0,0});
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
   
            for(int i = 0;i<size;i++){
               int [] p = q.poll();
               int r = p[0];
               int c = p[1];
               int lvl = p[2];
   
               if(r==n-1 && c == m-1)return steps;
   
               for(int j = 0;j<4;j++){
                  int nr = r + dr[j];
                  int nc = c + dc[j];
   
                  if(nr >= 0 && nr < n && nc >=0 && nc < m){
                   if(grid[nr][nc] == 1){
                       if(lvl < k && !visited[nr][nc][lvl+1]){
                           visited[nr][nc][lvl+1] = true;
                           q.offer(new int [] {
                           nr,nc,lvl + 1});
                       }
                   }
                   else{
                       if(!visited[nr][nc][lvl]){
                           visited[nr][nc][lvl] = true;
                           q.offer(new int [] {nr,nc,lvl});
                       }
                   }
                  }
               }
            }
            steps++;
        } 

        return -1;
    }
}