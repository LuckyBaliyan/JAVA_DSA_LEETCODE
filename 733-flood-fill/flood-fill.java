class Solution {
    public static int [][] visited;
    int [] dr = {-1,1,0,0};
    int [] dc = {0,0,-1,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];

        visited = new int [n][m];

        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {sr,sc,color});
        visited[sr][sc] = 1;
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr > - 1 && nr < n && nc > -1 && nc < m &&
                visited[nr][nc] == 0 && image[nr][nc] == originalColor){
                    image[nr][nc] = curr[2];
                    visited[nr][nc] = 1;
                    q.offer(new int [] {nr,nc,curr[2]});
                }
            }
        }

        return image;
    }
}