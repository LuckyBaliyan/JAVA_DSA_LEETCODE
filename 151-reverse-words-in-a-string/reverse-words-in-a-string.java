class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        int i = n-1;
        int j = n-1;


        StringBuilder sb = new StringBuilder();

        while(i>=0){
            if(s.charAt(i) == ' '){
               if( j > i){
               sb.append(s.substring(i+1,j+1));
               sb.append(" ");
               }
               j = i - 1;
            }
            else if (i == 0){
                sb.append(s.substring(i,j+1));
            }

            i--;
        }

        return sb.toString().trim();
    }
}