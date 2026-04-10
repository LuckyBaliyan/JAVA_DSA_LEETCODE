class Solution {
    static int [][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++)sum += nums[i];
        //if the total sum is odd so array can't be splitted in 2 equal parts
        if(sum % 2 != 0)return false;
        
        //half part subset sum
        int target = sum / 2;
        dp = new int [n][target + 1];

        for(int [] a: dp)Arrays.fill(a,-1);

        return solve(nums,n-1,target) == 1 ? true : false;
    }

    int solve(int [] arr, int n,int target){
        //if we are able to find 1 subset rest must also equal
        if(target == 0)return 1;

        if(target < 0)return 0;
        if(n < 0)return 0;

        if(dp[n][target] != -1)return dp[n][target];

        int skip = solve(arr,n-1,target);
        int take = solve(arr,n-1,target - arr[n]);

        return dp[n][target] = ((skip == 0) && (take == 0)) ? 0 : 1;
    }
}