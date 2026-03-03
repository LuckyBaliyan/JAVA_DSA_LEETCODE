class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";

        for(int i = 2;i<=n;i++){
            StringBuilder temp = new StringBuilder();
            temp.append(s);
            temp.append("1");
            StringBuilder revInvert = new StringBuilder(revIn(s));
            revInvert.reverse();

            temp.append(revInvert);
            s = temp.toString();
        }

        return s.charAt(k - 1);
    }

    public static String revIn(String s){
        if(s.length() == 0)return "";
        StringBuilder sb = new StringBuilder();

        for(char ch:s.toCharArray()){
            sb.append(ch == '0'?"1":"0");
        }

        return sb.toString();
    }
}