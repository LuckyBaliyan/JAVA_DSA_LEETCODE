class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int [][] dp = new int [n1][n2];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(word1,word2,0,0,dp);
    }

    //Memoization -->
    public static int solve(String w1, String w2,int i,int j,int [][] dp){
        int n1 = w1.length();
        int n2 = w2.length();

        //return the remaining chars when a big string ends
        if(i == n1)return n2 - j;
        if(j == n2)return n1 - i;

        if(dp[i][j] != -1)return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j)){
            return solve(w1,w2,i+1,j+1,dp);
        }

        int insert = solve(w1,w2,i+1,j,dp);
        int del = solve(w1,w2,i,j+1,dp);
        int rep = solve(w1,w2,i+1,j+1,dp);

        return dp[i][j] =  1 + Math.min(insert,Math.min(del,rep));
    }

    //Tabulation
   /* public static int solveTab(String w1,String w2){
        int n1 = w1.length();
        int n2 = w2.length();

        int [][] dp = new int [n1][n2];

        for(int i = 0;i<n1;i++){
            
        }
    }
    */
}