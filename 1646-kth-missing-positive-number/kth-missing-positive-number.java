class Solution {
    public int findKthPositive(int[] arr, int k) {
       int n = arr.length;
       int h = arr[n-1];

       int missing = 0;

       HashSet<Integer> st = new HashSet<>();

       for(int i: arr){
        st.add(i);
       }

       for(int i = 1;i<=h;i++){
        if(!st.contains(i)){
            missing = i;
            k--;
            if(k == 0)return missing;
        }
       }

       if(k > 0){
        return arr[n-1]+k;
       } 

       return -1;
    }
}