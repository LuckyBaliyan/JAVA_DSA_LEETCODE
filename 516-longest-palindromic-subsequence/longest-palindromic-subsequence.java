class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //int [][] dp = new int [n][n];
        //for(int [] arr:dp)Arrays.fill(arr,-1);
        return solveTab(s);
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

        //base case for all l == r
        for(int i = 0;i<n;i++){
            dp[i][i] = 1;
        }

        for(int gap = 1; gap < n; gap++){
            for(int l = 0; l + gap < n; l++){
                int r = l + gap;
    
                if(s.charAt(l) == s.charAt(r)){
                    dp[l][r] = 2 + (gap == 1 ? 0 : dp[l+1][r-1]);
                } else {
                    dp[l][r] = Math.max(dp[l+1][r], dp[l][r-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}