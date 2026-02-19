class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int curr  = 1;
        int prev = 0;
        int res = 0;

        for(int i = 1;i<n;i++){
            if(s.charAt(i) == s.charAt(i-1))curr++;
            if(s.charAt(i) != s.charAt(i-1)){
                res += Math.min(curr,prev);
                prev = curr;
                curr = 1;
            }
        }

        return res + Math.min(curr,prev);
       
       // Brute Force --> O(N^2) TLE
       /*
        for(int i = 0;i<n;i++){
            int count0 = 0;int count1 = 0;
            int change = 0;

            for(int j = i;j<n;j++){
                if(j > i && s.charAt(j) != s.charAt(j-1))change++;

                if(change > 1)break;

                if(s.charAt(j) == '0')count0++;
                else count1++;

                if(count0 == count1)count++;
            }
        }

        return count;
        */
    }
}