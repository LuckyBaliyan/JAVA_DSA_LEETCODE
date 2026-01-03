class Solution {
    public String removeOuterParentheses(String s) {
        int idx = -1;
        int n = s.length();

        int cnt1 = 0;
        int cnt2 = 0;

        String temp = "";

        for(int i = 0;i<n;i++){
          if(s.charAt(i) == '(')cnt1++;
          else cnt2++;

          if(cnt1 == cnt2){
            temp += s.substring(idx + 2,i);
            idx = i;
          }
        }

        return temp;
    }
}