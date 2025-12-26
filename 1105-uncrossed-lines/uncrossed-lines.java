class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // in case of confusion b/w filling dp with -1 ask urself is zero can be an answer or not
        /*int [][] dp = new int [n1+1][n2+1];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(nums1,nums2,n1,n2,0,0,dp);
        //return solve(nums1,nums2,n1,n2,0,0);
        */
        return solve(nums1,nums2);
    }

    /*
    public static int solve(int [] a,int [] b,int n1,int n2,int i,int j){
        if(i == n1 || j == n2)return 0;

        if(a[i] == b[j])return 1 + solve(a,b,n1,n2,i+1,j+1);
        return Math.max(
            solve(a,b,n1,n2,i+1,j),
            solve(a,b,n1,n2,i,j+1)
        );
    }
    */

    public static int solve(int [] a,int [] b,int n1,int n2,int i,int j,int [][] dp){
        if(i == n1 || j == n2)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(a[i] == b[j])return dp[i][j] = 1 + solve(a,b,n1,n2,i+1,j+1,dp);
        return dp[i][j] =  Math.max(
            solve(a,b,n1,n2,i+1,j,dp),
            solve(a,b,n1,n2,i,j+1,dp)
        );
    }

    public static int solve(int [] a,int [] b){
        int n = a.length;
        int m = b.length;

        int [][] dp = new int [n+1][m+1];

        for(int i = n - 1;i>=0;i--){
           for(int j = m - 1;j>=0;j--){
              if(a[i] == b[j]) dp[i][j] = 1 + dp[i+1][j+1];
              else dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
           }
        }

        return dp[0][0];
    }
}