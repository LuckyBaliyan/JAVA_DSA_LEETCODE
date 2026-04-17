class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p);
    }

    public static boolean solve(String s, String p){
        if(p.length() == 0){
            if(s.length() == 0)return true;
            return false;
        }

        boolean matched = false;

        if(s.length() > 0 && 
        (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
        matched = true;

        if(p.length() >=2 && p.charAt(1) == '*'){
            boolean take  = matched && solve(s.substring(1), p);
            boolean skip = solve(s, p.substring(2)); 
            //dont take .*

            return take || skip;
        }

        return matched && solve(s.substring(1), p.substring(1));
    }
}