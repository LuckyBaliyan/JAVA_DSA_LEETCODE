class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        if(n == 1){
            if(nums[0] == 0)return 2;
            if(nums[0] == target)return 1;
        }

        return solveRec(nums,target,0,0,n);
    }

    public static int solveRec(int [] arr,int t,int curr,int i,int n){
        if(i==n && curr == t)return 1;
        if(i>=n)return 0;

        int neg = solveRec(arr,t,curr-arr[i],i+1,n);
        int pos = solveRec(arr,t,curr+arr[i],i+1,n);

        return neg+pos;
    }
}