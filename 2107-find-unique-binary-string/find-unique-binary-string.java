class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        HashSet<String> st = new HashSet<>();
        for(String i:nums)st.add(i);
        
        
        StringBuilder sb = new StringBuilder();
        //Recursive Function to build all possible n length
        // binaryStrings and check them via Set

        checkRec(sb,"",n,st);

        return sb.toString();
    }

    public static void checkRec(StringBuilder sb,String curr,int len,HashSet<String> st){
        //BaseCase 
        if(curr.length() == len){
          if(!st.contains(curr)){
            sb.setLength(0);
            sb.append(curr);
          }
          return;
        }

        checkRec(sb,curr+"0",len,st);
        checkRec(sb,curr+"1",len,st);
    }
}