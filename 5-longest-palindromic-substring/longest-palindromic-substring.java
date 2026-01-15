class Solution {
    public String longestPalindrome(String s) {
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