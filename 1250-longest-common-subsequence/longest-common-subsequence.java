class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int n1 = text1.length();
       int n2 = text2.length();

       int [][] dp = new int [n1][n2];
       for(int [] arr:dp)Arrays.fill(arr,-1);
       return solve(text1,text2,n1-1,n2-1,dp); 
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

    public static int solve(String t1,String t2,int n1,int n2,int [][] dp){
        if(n1 < 0 || n2 < 0 )return 0;

        if(dp[n1][n2] != -1)return dp[n1][n2];

        if(t1.charAt(n1) == t2.charAt(n2)){
            return dp[n1][n2] =  1+solve(t1,t2,n1-1,n2-1,dp);
        }
        else{
            return dp[n1][n2] = Math.max(solve(t1,t2,n1-1,n2,dp),solve(t1,t2,n1,n2-1,dp));
        }
    }
}