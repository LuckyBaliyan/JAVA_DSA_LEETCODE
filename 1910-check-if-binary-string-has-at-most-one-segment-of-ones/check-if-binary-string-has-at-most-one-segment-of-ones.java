class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        //int segments = 0;

        if(n == 1 && s.charAt(0) == '1')return true;

        //There are no leading zeros that's means it will always start
        //with a 1 so can we loop till all leading 1's they will be in 
        // a single segment so segment = 1 now then check if there's another 
        // 1 in remaing string if yes return false;

        int first = 0;
        while(first < n && s.charAt(first) == '1')first++;
        if(first == n-1)return true; //all were 1's

        while(first < n){
           if(s.charAt(first) == '1')return false;
           first++;
        }

        return true;
    }
}