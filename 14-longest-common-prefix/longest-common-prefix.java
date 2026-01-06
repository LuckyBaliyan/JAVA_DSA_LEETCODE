class Solution {
    public String longestCommonPrefix(String[] strs) {
       int n =  strs.length;
       if(n == 0)return "";
       Arrays.sort(strs);

       /*

       StringBuilder sb = new StringBuilder();
       String firstPrifix = strs[0];
       int cnt  = firstPrifix.length();

       if(cnt  == 0)return "";


       for(int i = 1;i<n;i++){
        
        if(strs[i].length() == 0)return "";

         char [] arr = strs[i].toCharArray();
         if(firstPrifix.charAt(0) != arr[0]){
            cnt  = 0;
            break;
         }

         int k = 0;
         int min = 0;

        while( k < arr.length && k < firstPrifix.length()){
           if(firstPrifix.charAt(k) == arr[k]){
            min++;
           }
           else break;
           k++;
        }

         cnt  = Math.min(cnt,min);
       }

       sb.append(firstPrifix.substring(0,cnt));
       return sb.toString();
       */

       //simply u can say that all the same appearing and length strings must have 
       //been sorted together now if they all share a comman prefix so the first and   last also and last can be of smallest size in possible cases and we just want to find the comman prefix among all

       String first  = strs[0];
       String last = strs[n-1];

       if(first.equals(last))return first;

       for(int i = 0;i<Math.min(first.length(),last.length());i++){
        if(first.charAt(i) != last.charAt(i))return first.substring(0,i);
       }

       return first.substring(0,Math.min(first.length(),last.length()));
    }
}