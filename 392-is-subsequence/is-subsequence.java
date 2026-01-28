class Solution {
    static int [][] dp;
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        dp = new int [n1+1][n2+1];

        for(int [] a:dp)Arrays.fill(a,-1);

        return solveRec(s,t,n1-1,n2-1) == n1?true:false;
    }

    public static int solveRec(String s,String t,int i,int j){

        if(i<0 || j<0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + solveRec(s,t,i-1,j-1);
        }

        return dp[i][j] = Math.max(
            solveRec(s,t,i-1,j),
            solveRec(s,t,i,j-1)
        );
    }
}