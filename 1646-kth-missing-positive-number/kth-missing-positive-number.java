class Solution {
    public int findKthPositive(int[] arr, int k) {
       // return solveApproach1(arr,k);
       // return solveApproach2(arr,k);
       return Bs(arr,k);
    }

    public int Bs(int [] arr,int k){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low+(high - low)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k)low = mid+1;
            else high = mid - 1;
        }

        return low + k;
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

/*
    public  static int solveApproach2(int [] arr,int k){
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i] <= k)k++;
            else break;
        }

        return k;
    }
*/

}