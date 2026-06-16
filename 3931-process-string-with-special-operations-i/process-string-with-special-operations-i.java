class Solution {
    public String processStr(String s) {
        if(s.isEmpty())return "";

        StringBuilder sb = new StringBuilder();
        int r = -1;

        for(char ch: s.toCharArray()){
           if(ch == '*' && sb.isEmpty())continue;
           else if(ch == '*')sb.deleteCharAt(r--);
           else if(ch == '#' && r > -1){
            sb.append(sb.substring(0,r+1));
            r = sb.length() - 1;
           }
           else if(ch == '%' && r > 0)sb.reverse();
           else if (ch != '*' && ch != '#' && ch != '%'){
            sb.append(ch);
            r++;
           }
        }

        return sb.toString();
    }
}