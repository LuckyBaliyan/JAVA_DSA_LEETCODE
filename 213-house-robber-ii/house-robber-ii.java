class Solution {
    //static int [][][] dp;
    static int [][] dp;
    static int sum;

    public int rob(int[] nums) {
        // return approach1(nums); -->O(N * SUM * 2) and O(N*SUM*2) give MLE

        dp = new int [nums.length][2];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return approach2(nums,0,nums.length,0);
    }

    public static int approach2(int [] nums,int i,int n,int flag){
        if(i>=n)return 0;

        if(i == n-1 && flag == 1)return 0;

        if(dp[i][flag] != -1)return dp[i][flag];

        int notTake = approach2(nums,i+1,n,flag);
        int take = 0;
        
        if(i == 0){
            take = nums[i] + approach2(nums,i+2,n,1);
        }
        else take = nums[i] + approach2(nums,i+2,n,flag);

        return dp[i][flag] =  Math.max(take,notTake);
    }

  /*
    public static int approach1(int [] nums){
        int n = nums.length;

        for(int i = 0;i<n;i++)sum += nums[i];

        dp = new int [n][sum+1][2];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<sum;j++){
                for(int k = 0;k<2;k++)dp[i][j][k] = -1;
            }
        }

        return solveRec(nums,0,0,n,0);
    }

    public static int solveRec(int [] arr,int i,int s,
    int n,int flag){
        if(i>=n)return s;
    
        if(i == n-1 && flag == 1)return s;

        if(dp[i][s][flag] != -1)return dp[i][s][flag];

        int notTake = solveRec(arr,i+1,s,n,flag);
        int take = 0;
        if(i == 0 && flag == 0){
          take = solveRec(arr,i+2,s + arr[i],n,1);
        }
        else{
            take = solveRec(arr,i+2,s+arr[i],n,flag);
        }

        return dp[i][s][flag] =  Math.max(notTake,take);
    }
    */
}