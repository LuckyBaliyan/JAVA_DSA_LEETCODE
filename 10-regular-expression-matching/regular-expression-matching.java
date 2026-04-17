class Solution {
    public boolean isMatch(String s, String p) {
        return solve(0, 0, s, p);
    }

    public static boolean solve(int i, int j, String s, String p){
        if(j == p.length()){
            if(i == s.length())return true;
            return false;
        }

        boolean matched = false;

        if(i < s.length() && 
        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'))
        matched = true;

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean take  = matched && solve(i+1, j, s, p);
            boolean skip = solve(i, j+2, s, p); 
            //dont take .*

            return take || skip;
        }

        return matched && solve(i+1, j+1, s, p);
    }
}