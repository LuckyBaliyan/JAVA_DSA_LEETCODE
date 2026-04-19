class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max = 0;

        int l = 0;
        int r = 0;

        while(l < n && r < m){
            if(nums1[l] <= nums2[r] && l<=r){
                max = Math.max(max, (r - l));
                r++; // search for next max possibility
            }
            else if (nums1[l] > nums2[r]){
                l++;

                if( l > r){
                    r = l;
                }
            }
        }

        return max;
    }
}