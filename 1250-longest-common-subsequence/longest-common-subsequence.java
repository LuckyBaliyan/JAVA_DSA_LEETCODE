class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int n1 = text1.length();
       int n2 = text2.length();

       /*int [][] dp = new int [n1][n2];
       for(int [] arr:dp)Arrays.fill(arr,-1);
       return solve(text1,text2,n1-1,n2-1,dp); */

       return solveTab(text1,text2);
    }

   /*
    public static int solve(String t1,String t2,int n1,int n2){
        if(n1 < 0 || n2 < 0 )return 0;

        int count  = 0;
        if(t1.charAt(n1) == t2.charAt(n2)){
            return 1+solve(t1,t2,n1-1,n2-1);
        }
        else{
            return Math.max(solve(t1,t2,n1-1,n2),solve(t1,t2,n1,n2-1));
        }
    }
    */

    /*public static int solve(String t1,String t2,int n1,int n2,int [][] dp){
        if(n1 < 0 || n2 < 0 )return 0;

        if(dp[n1][n2] != -1)return dp[n1][n2];

        if(t1.charAt(n1) == t2.charAt(n2)){
            return dp[n1][n2] =  1+solve(t1,t2,n1-1,n2-1,dp);
        }
        else{
            return dp[n1][n2] = Math.max(solve(t1,t2,n1-1,n2,dp),solve(t1,t2,n1,n2-1,dp));
        }
    }
    */

    public static int solveTab(String t1,String t2){
        int n1 = t1.length();
        int n2 = t2.length();

        int [][] dp = new int [n1][n2];

        dp[0][0] = t1.charAt(0) == t2.charAt(0)?1:0;

        //filling up the rows
        for(int i = 1;i<n1;i++){
            if(t1.charAt(i) == t2.charAt(0))dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }

        //filling up the first column
        for(int j = 1;j<n2;j++){
            if(t1.charAt(0) == t2.charAt(j))dp[0][j] = 1;
            else dp[0][j] = dp[0][j-1];
        }

        for(int i = 1;i<n1;i++){
            for(int j = 1;j<n2;j++){
                if(t1.charAt(i) == t2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n1-1][n2-1];
    }
}