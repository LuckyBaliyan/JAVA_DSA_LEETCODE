class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int [n][amount + 1];
        for(int [] arr: dp)Arrays.fill(arr,-1);
        return solve(coins,amount);
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

/*
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
*/
    public static int solve(int [] arr,int target){
       int n = arr.length;

       int [][] dp = new int [n][target+1];

       //Base Case 
       for(int i = 0;i<n;i++){
        dp[i][0] = 1;
       }

       for(int j = 0;j<=target;j++){
        if(j % arr[0] == 0) dp[0][j] = 1;
       }

       for(int i = 1;i<n;i++){
        for(int j = 1;j<=target;j++){
            int take = 0;
            if(j>=arr[i]){
                take = dp[i][j - arr[i]];
            }
            int notTake = dp[i-1][j];
            dp[i][j] = take + notTake;
        }
       }

       return dp[n-1][target];  
    }
    
}