class Solution {
    public int lengthOfLongestSubstring(String s) {
      // return slidingWindow(s); --> O(N),O(N)

        return solveSet(s);

    }

    public static int solveSet(String s){
        int n = s.length();
        HashSet<Character> st = new HashSet<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while(right < n){
            char ch = s.charAt(right);
            while(st.contains(ch)){
              st.remove(s.charAt(left)); // must delete the previous character 
              left++;
            }

            st.add(ch);
            max = Math.max(max,(right - left)+1);
            right++;
        }

        return max;
    }

    public static int slidingWindow(String s){
        int n = s.length();
        int max = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);

            int idx = sb.indexOf(String.valueOf(ch));

            if(idx != -1){
                sb.delete(0,idx+1);
            }

            sb.append(ch);
            max = Math.max(max,sb.length());
        }

        return max;
    }
}