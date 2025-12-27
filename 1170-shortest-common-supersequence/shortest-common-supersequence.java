class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int [][] dp = new int [n+1][m+1];

        for(int i = n; i>=0; i--){
            dp[i][m] = n - i;
        }

        for(int j = m; j>=0; j--){
            dp[n][j] = m - j;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(str1.charAt(i) == str2.charAt(j))dp[i][j] = 1+dp[i+1][j+1];
                else dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }

        StringBuilder scs = new StringBuilder();
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(str1.charAt(i) == str2.charAt(j)){
                scs.append(str1.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] < dp[i][j+1]){
                scs.append(str1.charAt(i));
                i++;
            }
            else{
              scs.append(str2.charAt(j));
             j++;
            } 
        }

        while (i < n) scs.append(str1.charAt(i++));
        while (j < m) scs.append(str2.charAt(j++));

        return scs.toString();
    }
}