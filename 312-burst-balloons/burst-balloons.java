class Solution {
    static int [][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Create new array with boundaries
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int [n + 1][n + 1];
        for(int [] d: dp)Arrays.fill(d, -1);

        return solve(arr, 1, n);
    }

    public int solve(int[] arr, int i, int j) {
        if (i > j) return 0;
        int max = 0;

        if(dp[i][j] != -1)return dp[i][j];

        for (int k = i; k <= j; k++) {

            int cost = arr[i - 1] * arr[k] * arr[j + 1]
                     + solve(arr, i, k - 1)
                     + solve(arr, k + 1, j);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }
}