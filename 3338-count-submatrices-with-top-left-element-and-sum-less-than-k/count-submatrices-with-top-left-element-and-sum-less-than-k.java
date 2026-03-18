class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n  = grid.length;
        int m = grid[0].length;

        //precomputation for prefix-based precomputation
        for(int i = 1;i<n;i++){
          grid[i][0] += grid[i-1][0];
        }

        //same for first row
        for(int i = 1;i<m;i++){
            grid[0][i] += grid[0][i-1];
        }

        //now from (1,1) to (n,m)
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
               grid[i][j] = (
                grid[i][j] + grid[i][j-1] + grid[i-1][j]
                - grid[i-1][j-1]
               );
            }
        }

        //now let's just count for values in each row which are <= k
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] <= k)cnt++;
            }
        }

        return cnt;
    }
}