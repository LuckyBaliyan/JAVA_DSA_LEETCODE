class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashSet<Character> st = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while(right < n){
            char ch = s.charAt(right);
            
            //until we remove that char from window size
            while(st.contains(ch)){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(ch);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}