class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int [n][amount + 1];
        for(int [] arr: dp)Arrays.fill(arr,-1);
        return solve(coins,amount,n-1,dp);
    }

/* Plain Recusrsion
    public static int solve(int [] arr,int target,int i){
       if(target == 0)return 1;
       if(i < 0 || target < 0)return 0;

       int take = 0;
       if(target >= arr[i]){
        take = solve(arr,target - arr[i],i);
       }
       int notTake = solve(arr,target,i-1);
       return take + notTake; 
    }
*/
    public static int solve(int [] arr,int target,int i,int [][] dp){
       if(target == 0)return 1;
       if(i < 0 || target < 0)return 0;

       if(dp[i][target] != -1)return dp[i][target];

       int take = 0;
       if(target >= arr[i]){
        take = solve(arr,target - arr[i],i,dp);
       }
       int notTake = solve(arr,target,i-1,dp);
       return dp[i][target] = take + notTake; 
    }
}