class Solution {
    //public static int [] dp;
    public boolean canJump(int[] nums) {
        //dp = new int [nums.length];
        //Arrays.fill(dp,-1);
        //return solveRec(nums,0);

        /*int res = solveMemo(nums,0,dp);
        return res == 0?false:true;
        */

        return solveTab(nums) == 0?false:true;
        //O(N*K) , O(N)
    }

    public static int solveTab(int [] nums){
        int n = nums.length;

        int [] dp = new int [n];

        dp[n-1] = 1;

        for(int i = n-2;i>=0;i--){
            for(int j = 1;j<=nums[i];j++){
                if(dp[i+j] == 1){
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[0];
    }

    // Memoization Approach --> O(N*K) , O(2N)
    public static int solveMemo(int [] arr,int p,int [] dp){
        int n = arr.length;

        if(p>=n)return 0;
        if(p==n-1)return 1;

        if(arr[p] == 0)return 0;

        if(dp[p] != -1 )return dp[p];

       
        for(int i = 1;i<=arr[p] && i+p < n;i++){
           if(solveMemo(arr,p+i,dp) == 1)return dp[p] = 1;
        }

        return dp[p] = 0;
    }

   // Basic Recursive Solution --> 
    public static boolean solveRec(int [] arr,int p){
        int n = arr.length;

        if(p>=n)return false;
        if(p==n-1)return true;

        if(arr[p] == 0)return false;

       
        for(int i = 1;i<=arr[p] && i+p < n;i++){
           if(solveRec(arr,p+i))return true;
        }

        return false;
    }
}