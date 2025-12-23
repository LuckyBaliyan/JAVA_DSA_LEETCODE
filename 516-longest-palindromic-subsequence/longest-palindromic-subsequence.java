class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] dp = new int [n][n];
        for(int [] arr:dp)Arrays.fill(arr,-1);
        return solve(s,0,n-1,dp);
    }

    //Memoization
    public static int solve(String s,int l,int r,int [][] dp){
        if(l > r)return 0;
        if(l == r)return 1;

        if(dp[l][r] != -1)return dp[l][r];

        if(s.charAt(l) == s.charAt(r)){
          return dp[l][r] =  solve(s,l+1,r-1,dp)+2;
        }

        return dp[l][r] = Math.max(solve(s,l+1,r,dp),solve(s,l,r-1,dp));
    }

    public static int solveTab(String s){
        int n = s.length();

        int [][] dp = new int [n][n];

        //base cell if first pointers are same i.e 0,0 the letter is same
        dp[0][0] = 1;

        //base case for all l > r
        for(int i = 1;i<n;i++){
            dp[i][0] = 0;
        }

        for(int j = 1;j<n;j++){
            if(s.charAt(0) == s.charAt(j))dp[0][j] = 1;
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }

                dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }

        return dp[n-1][n-1];
    }
}