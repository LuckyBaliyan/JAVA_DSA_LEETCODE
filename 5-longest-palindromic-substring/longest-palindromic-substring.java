class Solution {
    public String longestPalindrome(String s) {
       //return extremeNaive(s);
       return solveDp(s);
    }

    public static String solveDp(String s){
        int n = s.length();

        if(n == 0)return "";
        if(n==1)return s;

        boolean [][] dp = new boolean [n][n];

        for(int i = 0;i<n;i++)dp[i][i] = true;
        
        int maxlen = 1;
        int start = 0;

        for(int len = 2;len <= n;len++){
            for(int l = 0;l+len-1<n;l++){
                int r = l + len -1;
                if(s.charAt(l) == s.charAt(r)){
                    if(len == 2 || dp[l+1][r-1]){
                        dp[l][r] = true;
                        if(len > maxlen){
                            start = l;
                            maxlen = len;
                        }
                    }
                }
            }
        }

        return s.substring(start,maxlen + start);
    }
    // O(n^3) --> Brute Force
    public static String extremeNaive(String s){
           int n = s.length();
        int maxLen = 0;

        StringBuilder res = new StringBuilder();

        for(int i = 0;i<n;i++){
            for(int j = n-1;j>=i;j--){
                int len = 0;
                String sb = s.substring(i,j+1);
                if(isValid(sb)) len = sb.length();
   
                if(len > maxLen){
                    res.replace(0,res.toString().length(),sb);
                    maxLen = len;
                }

            }
        }

        return res.toString();
    }

    public static boolean isValid(String s){
        int n = s.length();

        int i = 0;
        int j = n-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }

        return true;
    }
}