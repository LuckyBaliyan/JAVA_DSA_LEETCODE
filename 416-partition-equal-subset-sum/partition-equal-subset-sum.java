class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        for(int num : nums)sum+=num;
        if(sum % 2 == 1)return false;
        Boolean [][] dp = new Boolean [n][sum/2+1];
        return solve(nums,n-1,sum/2,dp);
    }

  /* plain recursion 
    public boolean solve(int [] nums,int i,int sum){
        if(sum== 0)return true;
        if(i == 0)return nums[i] == sum;

        if(nums[i] <= sum){
            return solve(nums,i-1,sum-nums[i]) || solve(nums,i-1,sum);
        }
        else return solve(nums,i-1,sum);
    }
    */

    //MemoiZation
    public boolean solve(int [] nums,int i,int sum,Boolean [][] dp){
        if(sum== 0)return true;
        if(i == 0)return nums[i] == sum;
        if(dp[i][sum] != null)return dp[i][sum];

        if(nums[i] <= sum){
            return dp[i][sum]  = solve(nums,i-1,sum-nums[i],dp) || solve(nums,i-1,sum,dp);
        }
        else return dp[i][sum] = solve(nums,i-1,sum,dp);
    }
}