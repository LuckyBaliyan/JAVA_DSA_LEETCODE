class Solution {
    public static int [][] dp;
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ans = 0;

        dp = new int [n+1][m+1];


        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans =  Math.max(solve(nums1,nums2,n,m,i,j),ans);
            }
        }

        return ans;
    }
  
    //Basic plain recursion for each (i,j) 
    public static int solve(int [] arr1,int [] arr2,int n,int m,int i,int j){
        if(i ==  n || j == m)return 0;

        if(dp[i][j] != 0)return dp[i][j];

        if(arr1[i] == arr2[j])return dp[i][j] = solve(arr1,arr2,n,m,i+1,j+1)+1;
        return dp[i][j] =  0;
    }
}