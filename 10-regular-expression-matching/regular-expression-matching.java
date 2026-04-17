class Solution {
    static int [][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int [s.length() + 1][p.length() + 1];

        for(int [] d: dp)Arrays.fill(d, -1);
        int res =  solve(0, 0, s, p);
        return res == 1 ? true : false;
    }

    public static int solve(int i, int j, String s, String p){
        if(j == p.length()){
            if(i == s.length())return 1;
            return 0;
        }

        if(dp[i][j] != -1)return  dp[i][j];

        boolean matched = false;

        if(i < s.length() && 
        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'))
        matched = true;

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            int take  = matched && (solve(i+1, j, s, p) == 1) ? 1 : 0;
            int skip = solve(i, j+2, s, p) == 1? 1 : 0; 
            //dont take .*

            return dp[i][j] = (take + skip == 0) ? 0 : 1;
        }

        return dp[i][j] =  (matched && (solve(i+1, j+1, s, p) == 1))?1: 0;
    }
}