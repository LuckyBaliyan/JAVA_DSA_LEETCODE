class Solution {
    public int findKthPositive(int[] arr, int k) {
       // return solveApproach1(arr,k);

       return solveApproach2(arr,k);
    }

   /*
    public static int solveApproach1(int [] arr,int k){
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
    */

    public  static int solveApproach2(int [] arr,int k){
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i] <= k)k++;
            else break;
        }

        return k;
    }
}