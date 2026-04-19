class Solution {
    static int [][] dp;
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        dp = new int [n][k+1];

        for(int [] d : dp)Arrays.fill(d, -1);

        return solve(nums, 0, n, k);
    }

    public static int solve(int [] arr, int i,  int n, int k){
        //if last partiton
        if(k == 1){
            int sum = 0;
            for(int x = i; x < n; x++){
                sum += arr[x];
            }

            return sum;
        }

        if(dp[i][k] != -1)return dp[i][k];

        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = i; j<= n-k; j++){
            sum += arr[j];
            int next = solve(arr, j+1, n, k-1);
            
            int maxPart = Math.max(sum, next);
            ans = Math.min(ans, maxPart);
        }

        return dp[i][k] = ans;
    }
}