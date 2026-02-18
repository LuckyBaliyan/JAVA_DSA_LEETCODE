class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        return isAlternate(binary);
    }

    public static boolean isAlternate(String s){
        for(int i = 1;i<s.length();i++){
            if((s.charAt(i) == '1' && s.charAt(i-1) != '0')
            ||
            (s.charAt(i) == '0' && s.charAt(i-1) != '1'))
            return false;
        }

        return true;
    }
}