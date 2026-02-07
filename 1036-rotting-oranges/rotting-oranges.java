class Solution {
    //static boolean [][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static class Node{
        public int sr,sc,time;

        Node(int sr,int sc,int time){
            this.sr = sr;
            this.sc = sc;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        //visited = new boolean [n][m];
        Queue<Node> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                   q.offer(new Node(i,j,0));
                }
                if(grid[i][j] == 1)fresh++;
            }
        }

        int finalTime = 0;

        while(!q.isEmpty()){
           Node curr = q.poll();
           finalTime  = Math.max(finalTime,curr.time);

           for(int i = 0;i<4;i++){
              int nr = dr[i] + curr.sr;
              int nc = dc[i] + curr.sc;

              if(nr >= 0 && nr < n && nc >=0 && nc < m 
               && grid[nr][nc] == 1){
                grid[nr][nc] = 2; // Marks as rotted
                fresh--; //this is not a fresh one now
                q.offer(new Node(nr,nc,curr.time+1));
              }
           }
        }

        return fresh == 0 ? finalTime : -1;
    }
}