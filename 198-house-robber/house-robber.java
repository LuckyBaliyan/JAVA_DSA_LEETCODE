class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int [] dp = new int [n];

        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];

        for(int i = 1; i<n; i++){
            int skip = dp[i-1];
            int take = (i - 2 < 0) ? nums[i] : dp[i-2] + nums[i];

            dp[i] = Math.max(skip, take); 
        }

        return dp[n-1];
    }
}