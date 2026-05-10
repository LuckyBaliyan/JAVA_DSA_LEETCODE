class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(char ch : columnTitle.toCharArray()){
            int val = ch - 'A' + 1; //1 based numbering
            res = res * 26 + val;
        }

        return res;
    }
}