class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int idx = -1;
        
        for(int i = n - 1;i>=0;i--){
            int dig = num.charAt(i) - '0';
            if(dig % 2 == 1 ){
                idx = i;
                break;
            }
        }

        return num.substring(0,idx+1);
    }
}