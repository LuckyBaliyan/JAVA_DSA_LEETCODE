class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int [] dp = new int [n];

        int max = 0;

        for(int i = 1; i<n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                }
                else{
                    int prevLen = dp[i-1];
                    int idx = i - prevLen  - 1;

                    if(idx >= 0 && s.charAt(idx) == '('){
                        dp[i] = prevLen + 2 + 
                        (idx - 1>=0 ? dp[idx - 1]: 0 );
                    }
                } // ))
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}