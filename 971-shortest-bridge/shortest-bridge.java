class Solution {
    public static int [] dr = {1,-1,0,0};
    public static int [] dc = {0,0,-1,1};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m];
        boolean found = false;
        Queue<int []> q = new LinkedList<>();

        for(int i = 0;i<n && !found;i++){
            for(int j = 0;j<m && !found;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid,n,m,i,j,visited,q);
                    found = true;
                }
            }
        }

        return bfs(grid,n,m,visited,q);
    }

    public static void dfs(int [][] grid,int n,int m,int i,int j,
    boolean [][] visited,Queue<int[]> q){
            visited[i][j] = true;
            q.add(new int [] {i,j}); // fill up all the cells of first land 

            if(i > 0 && !visited[i-1][j] && grid[i-1][j] == 1)
            dfs(grid,n,m,i-1,j,visited,q);
            
            if(i +1 < n && !visited[i+1][j] && grid[i+1][j] == 1)
            dfs(grid,n,m,i+1,j,visited,q);

            
            if(j > 0 && !visited[i][j-1] && grid[i][j-1] == 1)
            dfs(grid,n,m,i,j-1,visited,q);

            
            if(j + 1 < m && !visited[i][j+1] && grid[i][j+1] == 1)
            dfs(grid,n,m,i,j+1,visited,q);
    }

    public static int bfs(int [][] grid,int n,int m,
    boolean [][] visited,Queue<int []> q){
        int distance = 0;

        while(!q.isEmpty()){
            int level = q.size();

            while(level > 0){
                int [] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
               
                for(int i = 0;i<4;i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc])
                    continue;

                    if (grid[nr][nc] == 1)
                    return distance;
                        
                    q.add(new int [] {nr,nc});
                    visited[nr][nc] = true;
                }
               level--;
            }
            distance++;
        }

        return distance;
    }
}