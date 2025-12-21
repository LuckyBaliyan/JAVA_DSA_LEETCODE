class Solution {
    public static final int INF = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int [n][amount + 1];
        for(int [] arr:dp)Arrays.fill(arr,-1);
        int ans =  solve(coins,n-1,amount,dp);
        return ans >= INF ? -1:ans;
    }

   /* Plain Recursion 
    public static int solve(int [] arr,int i,int target){
        if(target == 0)return 0;
        if(target < 0)return INF;
        if(i < 0)return INF;

        int skip = solve(arr,i-1,target);

        //not i-1 because we can use it ultimately
        int choose = 1 + solve(arr,i,target - arr[i]);
        return Math.min(skip,choose);
    }
    */

    public static int solve(int [] arr,int i,int target,int [][] dp){
        if(target == 0)return 0;
        if(target < 0)return INF;
        if(i < 0)return INF;

        if(dp[i][target] != -1)return dp[i][target];

        int skip = solve(arr,i-1,target,dp);

        //not i-1 because we can use it ultimately
        int choose = 1 + solve(arr,i,target - arr[i],dp);
        return dp[i][target] =  Math.min(skip,choose);
    }
}
