class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        int n = grid.size();
        int m = grid.get(0).size();

        int [][] path = new int [n][m];
        
        for(int [] arr:path)Arrays.fill(arr,Integer.MAX_VALUE);
        path[0][0] = grid.get(0).get(0);

        pq.offer(new int [] {grid.get(0).get(0),0,0});

        while(!pq.isEmpty()){
            int [] p = pq.poll();
            int cost = p[0];
            int r = p[1];
            int c = p[2];
            
            if(r==n-1 && c==m-1)return cost<health;
            if(cost > path[r][c])continue;

            for(int i =0;i<4;i++){
              int nr = r + dr[i];
              int nc = c + dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m){
              if(cost + grid.get(nr).get(nc) < path[nr][nc]){
                path[nr][nc] = cost + grid.get(nr).get(nc);
                pq.offer(new int [] {cost+grid.get(nr).get(nc),nr,nc});
              }
            }}
        }

        return false;
    }
}