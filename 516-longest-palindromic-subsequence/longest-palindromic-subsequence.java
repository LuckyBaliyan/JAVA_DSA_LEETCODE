class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] dp = new int [n][n];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(s,0,n-1,dp);
    }

    public static int solve(String s,int l,int r,int [][] dp){
        int n = s.length();

        if(l > n || r < 0)return 0;
        if(l>r)return 0;

        if(l == r)return 1;

        if(dp[l][r] != -1)return dp[l][r];

        int take = 0;
        if(s.charAt(l) == s.charAt(r)){
            // if b == b so length is 2 not 1 so +2 instead of +1
            take = solve(s,l+1,r-1,dp)+2;
        }

        return dp[l][r] = Math.max(
            take,
            Math.max(solve(s,l+1,r,dp),solve(s,l,r-1,dp))
            );
    }
}