class Solution {
    public String findDifferentBinaryString(String[] nums) {
       // return approach1(nums); TC --> O(2^N) SC:--> O(3N)

       //approach 2 based on Cantor's Diagonalization
       return approach2(nums);
    }

    public static String approach2(String [] nums){
        int n = nums.length;

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            //get the diagonal character
            char ch = nums[i].charAt(i);
            sb.append((ch == '0'?'1':'0'));
        }

        return sb.toString();
    }

    public static String approach1(String [] nums){
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