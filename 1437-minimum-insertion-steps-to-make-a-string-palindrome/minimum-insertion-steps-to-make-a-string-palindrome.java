class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        //int [][] dp = new int [n][n];

        //for(int [] arr:dp)Arrays.fill(arr, -1);

        //return solveMemo(s,0,n-1,dp);

        return solveTab(s);
    }

    public static int solveMemo(String s,int i,int j,int [][] dp){
        if(i >= j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return solveMemo(s, i+1, j-1,dp);
        }

        return dp[i][j] = 1 + Math.min(solveMemo(s,i+1,j,dp),solveMemo(s,i,j-1,dp)); 
    }

    public static int solveTab(String s){
        int n = s.length();

        int [][] dp = new int [n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = 0;
        }

        for(int len = 2;len<=n;len++){
            for(int i = 0;i+len-1<n;i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}