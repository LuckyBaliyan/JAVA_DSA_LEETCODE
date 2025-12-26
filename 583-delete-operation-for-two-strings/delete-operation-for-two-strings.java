class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int [][] dp = new int [n1+1][n2+1];
        for(int [] arr:dp)Arrays.fill(arr,-1);

        return solve(word1,word2,n1,n2,0,0,dp);
    }

    public static int solve(String t1,String t2,int n1,int n2,int i,int j,int [][] dp){
        
        //if one of the string ends
        if(i == n1)return n2 - j;
        if(j == n2)return n1 - i;

        if(dp[i][j] != -1)return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)) return solve(t1,t2,n1,n2,i+1,j+1,dp);

        return dp[i][j] = Math.min(solve(t1,t2,n1,n2,i+1,j,dp),solve(t1,t2,n1,n2,i,j+1,dp))+1;
    }

    //tabulation
    public static int solveTab(String t1,String t2){
        int n1  = t1.length();
        int n2  = t2.length();

        int [][] dp = new int [n1+1][n2+1];

        //filling up the rows first 
        for(int i = n1;i>=0;i--){
            dp[i][n2] = n1 - i;
        }

        //filling up the columns 
        for(int j = n2;j>=0;j--){
            dp[n1][j] = n2 - j;
        }

        for(int i = n1-1;i>=0;i--){
            for(int j = n2-1;j>=0;j--){
                if(t1.charAt(i) == t2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+1;
            }
        }

        return dp[0][0];
    }
}