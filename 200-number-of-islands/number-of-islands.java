class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] visited = new boolean  [n][m];

        int isLands  = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, n, m, visited);
                    isLands++;
                }
            }
        }

        return isLands;
    }

    public static void dfs(char [][] arr,int i, int j, int n, int m, 
    boolean [][] visited){
        visited[i][j] = true;

        if(i - 1 >=0 && !visited[i-1][j] && arr[i-1][j] == '1')
        dfs(arr, i-1, j, n, m, visited);

        if(i+1 < n && !visited[i+1][j] && arr[i+1][j] == '1')
        dfs(arr, i+1, j, n, m, visited);

        if(j - 1 >= 0 && !visited[i][j-1] && arr[i][j-1] == '1')
        dfs(arr, i, j-1, n, m, visited);

        if(j + 1 < m && !visited[i][j+1] && arr[i][j+1] == '1')
        dfs(arr, i, j+1, n, m, visited);
    }
}