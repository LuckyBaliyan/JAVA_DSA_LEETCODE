class Solution {
    static int n,m;
    static int [][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new int [n][m][m];

        for(int i =0;i <n;i++){
            for(int j = 0; j<m;j++){
                for(int k = 0; k < m; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(grid, 0, 0, m-1);
    }

    public static int solve(int [][] arr, int r, int c1, int c2){
        if(r >= n)return 0;

        if(dp[r][c1][c2] != -1)return dp[r][c1][c2];

        int cherry = arr[r][c1];
        
        //if both are not in the same cell
        if(c1 != c2)cherry += arr[r][c2];   

        int ans = 0;
        
        //try all 9 combinations for rach R1 (-1 --> 1) try all r2 (-1,0,1)
        for(int i = -1; i<= 1; i++){
            for(int j = -1; j<= 1; j++){
                int newR = r + 1;

                int newC1 = c1 + i;
                int newC2 = c2 + j;

                if(newC1 >= 0 && newC1 < m && newC2 >= 0 && newC2 < m){
                    ans = Math.max(ans,solve(arr,newR,newC1,newC2));
                }
            }
        }

        return dp[r][c1][c2] =  cherry + ans; //add current cherry to previuos max ans
    }
}