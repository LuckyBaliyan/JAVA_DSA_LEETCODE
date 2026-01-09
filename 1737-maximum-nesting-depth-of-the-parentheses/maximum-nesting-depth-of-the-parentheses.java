class Solution {
    public int maxDepth(String s) {
        int n = s.length();

        int ans = 0;
        int open = 0;
        int close = 0;

        for(int w:s.toCharArray()){
            if(w == '(')open++;
            else if(w == ')')close++;

            if(open!= 0 && close != 0){
               ans = Math.max(ans,Math.max(open,close));
               open--;
               close--;
            }
        }

        return ans;

    }
}