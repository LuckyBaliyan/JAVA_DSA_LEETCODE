class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        //return Bs(dungeon,n,m);

        int [][] dp = new int [n][m];

        return solve(dungeon,0,0,dp);
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