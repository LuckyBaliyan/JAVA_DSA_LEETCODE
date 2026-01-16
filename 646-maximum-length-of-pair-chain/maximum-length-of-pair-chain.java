class Solution {
    public int findLongestChain(int[][] pairs) {
        return solveDp(pairs);
    }

    public static int solveDp(int [][] arr){
        int n = arr.length;

        Arrays.sort(arr,(a,b)-> a[0] - b[0]);
        // sort based on right values

        int [] dp = new int [n];
        Arrays.fill(dp,1);

        for(int i = 1;i<n;i++){
            for(int j = 0;j<=i-1;j++){
                if(arr[i][0] > arr[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                   // res = Math.max(res,dp[i]);
                }
            }
        }

        return dp[n-1];
    }
}