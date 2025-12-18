    class Solution {
        public int splitArray(int[] nums, int k) {
            int n = nums.length;
   /*  BS ON ANSWERS
            if(n < k)return -1;

            int lb = 0;
            int ub = 0;

            for(int i = 0;i<n;i++){
            lb  = Math.max(lb,nums[i]);
            ub += nums[i];
            }

            int  l = lb;
            int r =ub;

            while(l<=r){
                int mid = l+(r - l)/2;
                if(solve(nums,mid,k,n))r = mid-1;
                else l = mid+1;
            }

            return l;
*/
         //return solveRec(nums,0,n,k);
         int [][] dp = new int [n+1][k+1];
         for(int [] arr:dp)Arrays.fill(arr,-1);
         return solveRecMemo(nums,0,n,k,dp);
        }

/*   BS ON ANSWERS
        public static boolean solve(int [] arr,int max,int k,int n){
            int sum = 0;
            int subArrays = 1;

            for(int i = 0;i<n;i++){
                if(arr[i] > max)return false;
                if(arr[i]+sum <= max){
                sum += arr[i];
                }
                else{
                    subArrays++;
                    sum = arr[i];
                }
            }

            return subArrays <= k;
        }
    */
 /*  PLAIN RECURSION
    public static int solveRec(int [] arr,int i,int n,int k){
        //BASE CASE
        if(k == 1){
            int sum = 0;
            for(int j = i;j<n;j++)sum += arr[j];
            return sum;
        }

        int currSum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = i;j<=n-k;j++){
            currSum += arr[j];

            int right = solveRec(arr,j+1,n,k-1);
            int max = Math.max(right,currSum);

            ans = Math.min(ans,max);
        }

        return ans;
    }
    */

    //Memoization
    public static int solveRecMemo(int [] arr,int i,int n,int k,int [][] dp){
        //BASE CASE
        if(k == 1){
            int sum = 0;
            for(int j = i;j<n;j++)sum += arr[j];
            return sum;
        }

        if(dp[i][k] != -1)return dp[i][k];

        int currSum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = i;j<=n-k;j++){
            currSum += arr[j];

            int right = solveRecMemo(arr,j+1,n,k-1,dp);
            int max = Math.max(right,currSum);

            ans = Math.min(ans,max);
        }

        return dp[i][k] = ans;
    }
    
}