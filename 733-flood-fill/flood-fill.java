class Solution {
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0,-1,0,1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int sameColor = image[sr][sc];
        image[sr][sc] = color;

        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {sr,sc,color});

        boolean [][] visited = new boolean [n][m];

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int Currcolor = curr[2];

            for(int i = 0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && 
                !visited[nr][nc] && image[nr][nc] == sameColor){
                    visited[nr][nc] = true;
                    image[nr][nc] = Currcolor;

                    q.offer(new int [] {nr, nc, Currcolor});
                }
            }
        }

        return image;
    }
}