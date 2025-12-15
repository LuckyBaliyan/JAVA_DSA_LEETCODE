class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        for(int num : nums)sum+=num;
        if(sum % 2 == 1)return false;
        boolean [][] dp = new boolean [n][sum/2+1];
        return solveTab(nums,n,sum/2,dp);
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

    public boolean solveTab(int [] nums,int n,int sum,boolean [][] dp){
        //filling up the first row
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }

        //first condition matching case
        if(nums[0]<= sum){
            dp[0][nums[0]] = true;
        }

        for(int i = 1;i<n;i++){
            for(int s = 1;s<=sum;s++){
                boolean notTake = dp[i-1][s];
                boolean take = false;

                if(nums[i] <= s){
                    take = dp[i-1][s-nums[i]];
                }

                dp[i][s] = take || notTake;
            }
        }

        return dp[n-1][sum];
    }
}