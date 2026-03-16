class Solution {
    static int [] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i:nums)sum += i;

        /*dp = new int [n+1][sum+1];

        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solveRec(nums,0,0,n);*/

        return solveTab(nums);
    }

    public static int solveTab(int [] nums){
        int n = nums.length;

        dp = new int [n+1];
        //base case and i'm standing at 0 
        dp[0] = nums[0];

        for(int i = 1;i<n;i++){
            int prof1 = dp[i-1]; //if we don't rob curr house 
            int prof2 = (i-2 < 0)?nums[i]:dp[i-2] + nums[i];

            dp[i] = Math.max(prof1,prof2);
        }

        return dp[n-1];
    }

    /*public static int solveRec(int [] h, int i,int s,int n){
        if(i >= n)return s;

       // if(i == n-2 || i == n-1)return s;
       if(dp[i][s] != -1)return dp[i][s];

        int take = solveRec(h,i+2,s + h[i],n);
        int notTake = solveRec(h,i+1,s,n);

        return dp[i][s] = Math.max(take,notTake);
    }
    */
}