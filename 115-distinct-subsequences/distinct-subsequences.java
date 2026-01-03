class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        /*int[][] dp = new int[n+1][m+1];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(s,t,0,0,n,m,dp);*/

        //return solveTab(s,t);

        //solve with space Optimization 
        return solve(s,t);
    }

    public static int solve(String s, String t ){
        int n = s.length();
        int m = t.length();

        int [] dp = new int[m+1];

        dp[m] = 1;

        for(int i = n-1;i>=0;i--){
            int prev = dp[m];
            for(int j = m-1;j>=0;j--){
                int temp = dp[j];
                if(s.charAt(i) == t.charAt(j)){
                    dp[j] = dp[j]+prev;
                }
                prev = temp;
            }
        }

        return dp[0];
    }

    public static int solveTab(String s,String t){
        int n = s.length();
        int m = t.length();

        int [][] dp = new int[n+1][m+1];

        for(int i = n;i>=0;i--){
            dp[i][m] = 1;
        }

        for(int i=n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][0];
    }

    public static int solve(String s, String t, int i, int j,int n,int m, int[][] dp){
        if(j == m)return 1;
        if(i == n)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = solve(s,t,i+1,j+1,n,m,dp) + solve(s,t,i+1,j,n,m,dp);
        }
        else{
            return dp[i][j] = solve(s,t,i+1,j,n,m,dp);
        }
    }
}