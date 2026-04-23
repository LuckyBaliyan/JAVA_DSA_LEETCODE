class Solution {
    static boolean [][] visited;
    static int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean [n][m];

        int lands = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j);
                    lands++;
                }
            }
        }

        return lands;
    }

    public static void dfs(char [][] arr, int r, int c){
        visited[r][c] = true;

        if(r - 1 >= 0 && !visited[r-1][c] && arr[r-1][c] == '1')dfs(arr, r-1, c);
        if(r + 1 < n && !visited[r+1][c] && arr[r+1][c] == '1')dfs(arr, r+1, c);
        if(c - 1 >=0 && !visited[r][c-1] && arr[r][c-1] == '1')dfs(arr, r, c-1);
        if(c + 1 < m && !visited[r][c+1] && arr[r][c+1] == '1')dfs(arr, r, c+1);
    }
}