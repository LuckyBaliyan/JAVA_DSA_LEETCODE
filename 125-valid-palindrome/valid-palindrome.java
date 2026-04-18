class Solution {
    public static String transform(String s, int n){
        String t = "";

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);

            if(!Character.isLetterOrDigit(ch) || ch == ' ')continue;

            t += ch;
        }
        
        return t.toLowerCase().trim();
    }

    public boolean isPal(String t, int n){
        int l = 0;
        int r = n-1;

        while(l < r){
            if(t.charAt(l) != t.charAt(r))return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        String t = transform(s,n);

        return isPal(t, t.length());
    }
}