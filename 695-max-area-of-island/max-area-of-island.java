class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean [n][m];
        int maxArea = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid,visited,i,j,n,m);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }

        return maxArea;
    }

    public static int dfs(int [][] grid,boolean [][] visited,int i,int j,int n,int m){
        visited[i][j] = true;
        int area = 1;

        if(i>0 && !visited[i-1][j] && grid[i-1][j] == 1)
        area +=dfs(grid,visited,i-1,j,n,m);
        if(i+1 < n && !visited[i+1][j] && grid[i+1][j] == 1)
        area +=dfs(grid,visited,i+1,j,n,m);
        if(j>0 && !visited[i][j-1] && grid[i][j-1] == 1)
        area +=dfs(grid,visited,i,j-1,n,m);
        if(j+1 < m && !visited[i][j+1] && grid[i][j+1] == 1)
        area +=dfs(grid,visited,i,j+1,n,m);

        return area;
    }
}