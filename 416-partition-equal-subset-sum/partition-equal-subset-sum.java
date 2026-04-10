class Solution {
    //static int [][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++)sum += nums[i];
        //if the total sum is odd so array can't be splitted in 2 equal parts
        if(sum % 2 != 0)return false;
        
        //half part subset sum
        int target = sum / 2;
        //dp = new int [n][target + 1];

        //for(int [] a: dp)Arrays.fill(a,-1);

        //return solve(nums,n-1,target) == 1 ? true : false;

        return solveTab(nums,target);
    }

    /*int solve(int [] arr, int n,int target){
        //if we are able to find 1 subset rest must also equal
        if(target == 0)return 1;

        if(target < 0)return 0;
        if(n < 0)return 0;

        if(dp[n][target] != -1)return dp[n][target];

        int skip = solve(arr,n-1,target);
        int take = solve(arr,n-1,target - arr[n]);

        return dp[n][target] = ((skip == 0) && (take == 0)) ? 0 : 1;
    }*/

    boolean solveTab(int [] arr, int target){
        int n = arr.length;
        boolean [][] dp = new boolean [n][target+1];

        //base case fillUp
        for(int i = 0;i<n;i++)dp[i][0] = true;

        for(int i = 1;i<n;i++){
            for(int j = 1; j<= target; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;

                //check when we can actually pick i.e at min diff is 0; not lesser
                if(arr[i-1]<=j){
                   take = dp[i-1][j - arr[i-1]];
                }

                dp[i][j] = notTake || take;
            }
        }

        return dp[n-1][target];
    }
}