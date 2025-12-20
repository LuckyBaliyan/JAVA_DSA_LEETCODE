class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int [] arr = new int [m+n];
        int k = 0;int l =0;int r = 0;

        while(l<=m-1 && r<= n-1){
            if(nums1[l] <= nums2[r]){
                arr[k] = nums1[l++];
            }
            else{
                arr[k] = nums2[r++];
            }
            k++;
        }

        while(l<=m-1){
            arr[k++] = nums1[l++];
        }

        while(r<=n-1){
            arr[k++] = nums2[r++];
        }

        if((n+m)%2 != 0){
            return (double) arr[(n+m)/2];
        }
        else{
           return (double) (arr[(n+m)/2]+arr[((n+m)/2)-1])/2;
        }
 
    }
}