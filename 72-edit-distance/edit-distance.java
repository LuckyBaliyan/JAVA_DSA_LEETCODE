class Solution {
    static int n1;
    static int n2;

    static int [][] dp;

    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();

        dp = new int [n1][n2];
        for(int [] d: dp)Arrays.fill(d, -1);
        
        return solve(0, 0, word1, word2);
    }

    public int solve(int i, int j, String w1, String w2){
        if(i == n1)return n2 - j;
        if(j == n2)return n1 - i;

        if(dp[i][j] != -1)return dp[i][j];

        if(w1.charAt(i) == w2.charAt(j))
        return dp[i][j] =  solve(i+1, j+1, w1, w2);

        int insert = solve(i, j+1, w1, w2);
        int delete = solve(i+1, j, w1, w2);
        int replace = solve(i+1, j+1, w1, w2);

        return dp[i][j] =  1 + Math.min(insert, Math.min(delete, replace));
    }
}