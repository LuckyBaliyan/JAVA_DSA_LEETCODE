class Solution {
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0,-1,0,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int n = image.length;
       int m = image[0].length;

       boolean [][] visited = new boolean [n][m];
       Queue<int []> q = new LinkedList<>();

       int originalColor = image[sr][sc];

       q.offer(new int [] {sr,sc,color});
       visited[sr][sc] = true;
       image[sr][sc] = color;

       while(!q.isEmpty()){
          int [] curr = q.poll();
          int r = curr[0];
          int c = curr[1];
          int Prevcolor = curr[2];

          for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >=0 && nr < n && nc >=0 && nc < m && 
            image[nr][nc] == originalColor && !visited[nr][nc]){
                visited[nr][nc] = true;
                image[nr][nc] = Prevcolor;
                q.offer(new int [] {nr,nc,Prevcolor});
            }
          }
       }

       return image;
    }
}