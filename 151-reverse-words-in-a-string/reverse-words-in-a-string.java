class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        int end = n-1;

        for(int i = n-1;i >= 0;i-- ){
            char ch = s.charAt(i);

            if(ch == ' '){
              if( i < end){
                sb.append(s.substring(i+1,end+1)+" ");
              }
              end = i - 1;
            }
            else if (i == 0){
                sb.append(s.substring(i,end+1));
            }
        }

        return sb.toString().trim();

    }
}