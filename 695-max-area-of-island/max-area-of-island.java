class Solution {
    static boolean [][] visited;
    static int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        visited = new boolean [n][m];
        int maxArea = 0;

        for(int i = 0; i<n;i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                   int area = dfs(grid,i,j);
                   maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public static int dfs(int [][] arr, int r, int c){
        visited[r][c] = true;
        int area = 1;

        if(r - 1 >= 0 && !visited[r-1][c] && arr[r-1][c] == 1){
            area += dfs(arr, r-1, c);
        }

        if(r + 1 < n && !visited[r+1][c] && arr[r+1][c] == 1){
            area += dfs(arr, r+1, c);
        }

        if(c-1 >= 0 && !visited[r][c-1] && arr[r][c-1] == 1){
            area += dfs(arr, r, c-1);
        }

        if(c+1 < m && !visited[r][c+1] && arr[r][c+1] == 1){
            area += dfs(arr, r, c+1);
        }

        return area;
    }
}