class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m];
        int lands = 0;

        for(int i = 0;i<n;i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(grid,visited,i,0,n,m);
            }

            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                dfs(grid,visited,i,m-1,n,m);
            }
        }

        for(int j = 0;j<m;j++){
            if(grid[0][j] == 1 && !visited[0][j]){
                dfs(grid,visited,0,j,n,m);
            }

            if(grid[n-1][j] == 1 && !visited[n-1][j]){
                dfs(grid,visited,n-1,j,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j])lands++;
            }
        }

        return lands;
    }

    public static void dfs(int [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;

        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == 1)
        dfs(grid,visited,i-1,j,n,m);
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j] == 1)
        dfs(grid,visited,i+1,j,n,m);
        if(j > 0 && !visited[i][j-1] && grid[i][j-1] == 1)
        dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1] == 1)
        dfs(grid,visited,i,j+1,n,m);
    }
}