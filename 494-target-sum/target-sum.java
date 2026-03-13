class Solution {
    static int [][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        dp = new int [n][2001];

        for(int [] arr: dp)Arrays.fill(arr,-1);

        if(n == 1){
            if(nums[0] == 0)return 2;
            if(nums[0] == target)return 1;
        }

        //return solveRec(nums,target,0,0,n);

        return solveMemo(nums,target,0,0,n);
    }

    public static int solveMemo(int [] arr,int t,int curr,int i,int n){
        if(i==n && curr == t)return 1;

        if(i>=n)return 0;

        if(dp[i][curr + 1001] != -1) return dp[i][curr + 1001];

        
        int neg = solveMemo(arr,t,curr-arr[i],i+1,n);
        int pos = solveMemo(arr,t,curr+arr[i],i+1,n);

        return dp[i][curr+1001] = neg+pos;
    }

    public static int solveRec(int [] arr,int t,int curr,int i,int n){
        if(i==n && curr == t)return 1;
        if(i>=n)return 0;

        int neg = solveRec(arr,t,curr-arr[i],i+1,n);
        int pos = solveRec(arr,t,curr+arr[i],i+1,n);

        return neg+pos;
    }
}