class Solution {
    int [][][] dp;
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();

        dp = new int [n][n][k + 1];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int l = 0;l<k+1;l++)dp[i][j][l] = -1;
            }
        }
        return solveMemo(s,0,s.length()-1,k,dp);
    }

    public int solveMemo(String s,int i,int j,int k,int [][][] dp){
        if(i > j)return 0;

        if(i == j)return 1;

        if(dp[i][j][k] != -1)return dp[i][j][k];

        int left = solveMemo(s,i+1,j,k,dp);
        int right = solveMemo(s,i,j - 1,k,dp);

        int ans = Math.max(left,right);
        int cost = getCost(s.charAt(i),s.charAt(j));

        if(cost <= k){
            ans = Math.max(
              ans,
               2 + solveMemo(s,i+1,j-1,k - cost,dp)
            );
        }

        return dp[i][j][k] = ans;
    }

    public int getCost(char a,char b){
        int diff = Math.abs(a - b);
        return Math.min(diff,26 - diff);
    }
}