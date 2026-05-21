class Solution {
    public static int len(int num){
        int len = 0;
        while(num > 0){
            len++;

            num /= 10;
        }

        return len;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> st = new HashSet<>();
        
        //store all possible prefix can be formed using each num
        for(int num : arr1){
            while(num > 0){
                st.add(num);

                num /= 10;
            }
        }

        //compare for maxLen from arr2
        int maxLen = 0;

        for(int num : arr2){
            while(num > 0){
                if(st.contains(num)){
                  maxLen = Math.max(maxLen, len(num));
                }

                num /= 10;
            }
        }

        return maxLen;
    }
}