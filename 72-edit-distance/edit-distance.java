class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        //int [][] dp = new int [n1][n2];
        //for(int [] arr:dp)Arrays.fill(arr,-1);

        //return solve(word1,word2,0,0,dp);

        return solveTab(word1,word2);
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
    public static int solveTab(String w1,String w2){
        int n1 = w1.length();
        int n2 = w2.length();

        if(n1 == 0 && n2 == 0)return 0;

        int [][] dp = new int [n1+1][n2+1];

        //filling up the columns
        for(int i = n2;i>=0;i--){
            dp[n1][i] = n2-i;
        }

        //filling up the last row
        for(int j = n1;j>=0;j--){
            dp[j][n2] = n1 - j;
        }

        for(int i = n1-1;i>=0;i-- ){
            for(int j = n2-1;j>=0;j--){
                if(w1.charAt(i) == w2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else{
                    int ins = dp[i+1][j];
                    int rep = dp[i+1][j+1];
                    int del = dp[i][j+1];

                    dp[i][j] = 1 + Math.min(Math.min(ins,rep),del);
                }
            }
        }

        return dp[0][0];
    }
    
}