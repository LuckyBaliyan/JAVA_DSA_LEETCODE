class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m];
        int cnt = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               if(grid[i][j] == '1' && !visited[i][j]){
                  dfs(grid,visited,i,j,n,m);
                  cnt++;
               }
            }
        }

        return cnt;
    }

    public static void dfs(char [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;
        if(i + 1 < n && !visited[i+1][j] && grid[i+1][j] == '1')
        dfs(grid,visited,i+1,j,n,m);
        if(i>0 && !visited[i-1][j] && grid[i-1][j] == '1')
        dfs(grid,visited,i-1,j,n,m);
        if(j>0 && !visited[i][j-1] && grid[i][j-1] == '1')
        dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1] == '1')
        dfs(grid,visited,i,j+1,n,m);
    }
}