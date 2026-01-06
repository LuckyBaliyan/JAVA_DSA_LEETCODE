class Solution {
    public boolean isIsomorphic(String s, String t) {
        // the isomatric strings questions requires bijective mapping
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();

        int n = s.length();

        for(int i = 0;i<n;i++){
            char letter = s.charAt(i);
            if(map.containsKey(letter) && map.get(letter) != t.charAt(i))return false;
            map.put(s.charAt(i),t.charAt(i));

            char letter2 = t.charAt(i);
            if(map2.containsKey(letter2) && map2.get(letter2) != s.charAt(i))return false;
            map2.put(t.charAt(i),s.charAt(i));
        }

        return true;
    }
}