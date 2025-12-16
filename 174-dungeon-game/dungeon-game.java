class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        //return Bs(dungeon,n,m);

        int [][] dp = new int [n][m];

        return solveTab(dungeon);
    }

    public static int solveTab(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int [][] dp = new int [n][m];
        dp[n-1][m-1] = Math.max(1,1-arr[n-1][m-1]);

        for(int i = n-2;i>=0;i--){
            dp[i][m-1] = Math.max(1,dp[i+1][m-1] - arr[i][m-1]);
        }

        for(int i = m-2;i>=0;i--){
            dp[n-1][i] = Math.max(1,(dp[n-1][i+1] - arr[n-1][i]));
        }

        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                int right = dp[i][j+1];
                int down = dp[i+1][j];

                int result = Math.min(right,down) - arr[i][j];
                dp[i][j] = Math.max(1,result);
            }
        }

        return dp[0][0];
    }

    public static int solve(int [][] arr,int i,int j,int [][] dp){
        int n = arr.length;
        int m = arr[0].length;

        if(i >=n || j>=m)return Integer.MAX_VALUE;

        if(dp[i][j] != 0)return dp[i][j];

        if(i == n-1 && j == m-1){
            return Math.max(1,1 - arr[i][j]);
        }

        int right =  solve(arr,i,j+1,dp);
        int down = solve(arr,i+1,j,dp);

        int result = Math.min(right,down) - arr[i][j];
        return dp[i][j] =  Math.max(1,result);
    }

   /* BinarySearch on Answers + Plain Recursion Approach
    public static int Bs(int [][] arr,int n,int m){
        int l = 1;
        int r = 4 *(int)1e7;
        int minHealth = 0;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(solve(arr,0,0,mid)){
                minHealth = mid;
                r = mid-1;
            }
            else l = mid+1;
        }

        return minHealth;
    }

    public static boolean solve(int [][] arr,int i,int j,int health){
        int n = arr.length;
        int m = arr[0].length;

        if(i>n-1 || j>m-1)return false;
        health += arr[i][j];

        //first thing calculate the health score then move further
        
        if(health <= 0)return false;
        if(i==n-1 && j==m-1)return true;

        return solve(arr,i+1,j,health) || solve(arr,i,j+1,health);
    }
    */
}