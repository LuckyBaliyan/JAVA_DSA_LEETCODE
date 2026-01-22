class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;

        String s2 = s.trim();   
        int n = s2.length();

        for(int i = n-1;i>=0;i--){
            char ch = s2.charAt(i);

            if(ch != ' ')len++;
            else return len;
        }

        return n;
    }
}