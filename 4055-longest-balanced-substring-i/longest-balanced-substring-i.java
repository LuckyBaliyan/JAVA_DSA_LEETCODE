class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (isBalanced(map)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private boolean isBalanced(HashMap<Character, Integer> map) {

        int freq = -1;

        for (int val : map.values()) {
            if (freq == -1) {
                freq = val;
            } else if (freq != val) {
                return false;
            }
        }

        return true;
    }
}