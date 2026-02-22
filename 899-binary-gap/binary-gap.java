class Solution {
    public int binaryGap(int n) {
        return gap(Integer.toBinaryString(n));
    }

    static int gap(String s){
        int n = s.length();
        int slow = 0;

        while(s.charAt(slow) != '1')slow++;

        if(slow == n-1)return 0;
        int fast = slow + 1;
        int maxLen = 0;

        while(fast < n){
            char ch = s.charAt(fast);
           
           if(ch == '1'){
            maxLen = Math.max(maxLen,fast - slow);
            slow = fast;
           }

           fast++;
        }

        return maxLen;
    }
}