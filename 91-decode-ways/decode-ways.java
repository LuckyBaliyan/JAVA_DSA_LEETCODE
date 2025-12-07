class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int [n+1];
        //return numDecodingsRec(s,0,n);

        //Arrays.fill(dp,-1);
        //return solveTb(s,dp);
        //return solveMemo(s,0,n,dp);

        return solveTbSpace(s);
    }

    /* plain recursion
    public int numDecodingsRec(String s,int index,int n){
        if(index == n)return 1;
        if(s.charAt(index) == '0')return 0;

        int ways = numDecodingsRec(s,index+1,n);

        if(index + 1 < n){
            int num = (s.charAt(index) - '0')*10+(s.charAt(index+1) - '0');

            if(num>=10 && num<=26){
                ways += numDecodingsRec(s,index+2,n);
            }
        }

        return ways;
    }
    */

    /*public static int solveMemo(String s,int i,int n,int [] dp){
        if(i == n)return 1;
        if(s.charAt(i) == '0')return 0;

        if(dp[i] != -1)return dp[i];

        int ways = solveMemo(s,i+1,n,dp);

        if(i+1 < n){
            int num = (s.charAt(i) - '0')*10+(s.charAt(i+1) - '0');

            if(num >= 10 && num <= 26){
                ways += solveMemo(s,i+2,n,dp);
            }
        }

        dp[i] = ways;
        return dp[i];
    }*/

   /* public static int solveTb(String s,int [] dp){
        int n = s.length();
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0')?0:1;

        for(int i=2;i<=n;i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }

            int num = Integer.parseInt(s.substring(i-2,i));
            if(num >= 10 && num <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
    */

     public static int solveTbSpace(String s){
        int n = s.length();
        int prev2 = 1;
        int prev = (s.charAt(0) == '0')?0:1;

        for(int i=2;i<=n;i++){
            int curr = 0;
            if(s.charAt(i-1) != '0'){
                curr += prev;
            }

            int num = Integer.parseInt(s.substring(i-2,i));
            if(num >= 10 && num <= 26){
                curr += prev2;
            }

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}