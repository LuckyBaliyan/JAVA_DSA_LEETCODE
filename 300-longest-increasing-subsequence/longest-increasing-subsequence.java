class Solution {
    public int lengthOfLIS(int[] nums) {
        int n  = nums.length;
        int [][] dp = new int [n+1][n+1];

        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solveMemo(nums,0,-1,n,dp);
        //return tab(nums);
    }

    public static int tab(int [] nums){
        int n = nums.length;

        int [][] dp = new int [n+1][n+1];

        for(int i = n-1;i>=0;i--){
            for(int prev = -1;prev<=i-1;prev++){
                int take = 0;
                int skip = 0;
                if(prev == -1 || nums[i] > nums[prev] ){
                    take = 1 + dp[i+1][i+1];
                }
                // we don't have to use else jb max compute kr re 
                // because hme max ke liye dono values chaiye hr iteration pe!
                skip = dp[i+1][prev+1];
                dp[i][prev+1]  = Math.max(skip,take);
            }
        }

        return dp[0][0];
    }

    public static int solveMemo(int [] nums,int i,int prev,int n,int [][] dp){
        if(i>=n)return 0;

        if(dp[i][prev+1]!= -1)return dp[i][prev+1];

        int skip = solveMemo(nums,i+1,prev,n,dp);
        int take = 0;

        if(prev == -1 || nums[i] > nums[prev]){
            take = 1 + solveMemo(nums,i+1,i,n,dp);
        }

        return dp[i][prev+1] =  Math.max(take,skip);
    }
}