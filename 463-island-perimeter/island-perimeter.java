class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int res = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    res += 4;

                    if(i > 0 && grid[i-1][j] == 1)res--;
                    if(i+1 < n  && grid[i+1][j] == 1)res --;
                    if(j > 0 && grid[i][j-1] == 1)res--;
                    if(j+1 < m  && grid[i][j+1] == 1)res--;
                }
            }
        }

        return res;
    }
}