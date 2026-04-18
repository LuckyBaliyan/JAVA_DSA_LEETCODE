class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        if(n == 1)return 1;

        for(int i = 0; i<n; i++){
            HashSet<Character> st = new HashSet<>();
            for(int j = i; j<n; j++){
                char ch = s.charAt(j);
                
                if (st.contains(ch)){
                   break; //never add that substring
                }

                st.add(ch);
                maxLen = Math.max(maxLen, st.size());
            }
        }

        return maxLen;
    }
}