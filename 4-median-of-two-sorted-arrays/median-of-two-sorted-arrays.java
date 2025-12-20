class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        if(m > n)return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = m;

        int left = (m+n+1)/2;

        while(low <= high){
            int mid1 = low+(high - low)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < m) r1 = nums1[mid1];
            if(mid2 < n) r2 = nums2[mid2];

            if(mid1 - 1 >=0) l1 = nums1[mid1 - 1];
            if(mid2 - 1>= 0) l2 = nums2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if((n+m)%2 == 1) return Math.max(l1,l2);
                return ((double) (Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
            }
            else if (l1 > r2)high = mid1-1;
            else low = mid1+1;
        }

        return 0;

        /*int size = n+m;
        int id1= size/2;
        int id2 = id1 - 1;
        int count  = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        int i =0;int j =0;

        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                if(count == id1)el1 = nums1[i];
                if(count  == id2)el2 = nums1[i];
                i++;
            }
            else{
                if(count == id1)el1 = nums2[j];
                if(count == id2)el2 = nums2[j];
                j++;
            }
            count++;
            if(el1 != Integer.MIN_VALUE && el2  != Integer.MIN_VALUE)break;
        }

        while(i<m){
            if(count == id1)el1 = nums1[i];
            if(count  == id2)el2 = nums1[i];
            i++;
            count++;
        }

        while(j<n){
            if(count == id1)el1 = nums2[j];
            if(count == id2)el2 = nums2[j];
            j++;
            count++;
        }

        if(size%2!= 0)return el1;
        else return (el1 + el2)/2.0;
*/


/*
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
*/
 
    }
}