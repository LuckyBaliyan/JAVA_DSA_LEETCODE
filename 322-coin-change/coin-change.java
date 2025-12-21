class Solution {
    public static final int INF = (int) 1e9;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //int dp[][] = new int [n][amount + 1];
        //for(int [] arr:dp)Arrays.fill(arr,-1);
        //int ans =  solve(coins,n-1,amount,dp);

        int ans = solve(coins,amount);
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

    /*
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
    */

    //tabulation

    public static int solve(int [] arr,int target){
        int n = arr.length;

        int [][] dp = new int [n][target+1]; // target+1 size = 0 --> 11 (total 12)

        //Base case
        for(int i = 0;i<n;i++){
            dp[i][0] = 0;
        }

        //we will be moving from left ---> right just move apposite to recursion relation
        for(int j = 0;j<target+1;j++){
            if(j % arr[0] == 0) dp[0][j] = j / arr[0];
            else dp[0][j] = INF;
        }

        for(int i = 1;i<n;i++){
            for(int j = 0;j<target+1;j++){
                int skip = dp[i-1][j];
                int notSkip = INF;
                if(j>=arr[i]){
                    notSkip = dp[i][j-arr[i]]+1;
                }

                dp[i][j] = Math.min(skip,notSkip);
            }
        }

        return dp[n-1][target];

    }
}
