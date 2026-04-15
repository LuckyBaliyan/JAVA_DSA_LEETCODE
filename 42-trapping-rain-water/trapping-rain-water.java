class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;

        int [] leftMax = new int [n+1];
        int [] rightMax = new int [n+1];

        leftMax[0] = height[0];
        rightMax[0] = height[n-1];

        for(int i = 1; i<n; i++)
        {
          leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i = n-1; i>= 0; i--)
        {
          rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i = 0; i < n; i++){
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return water;
    }
}