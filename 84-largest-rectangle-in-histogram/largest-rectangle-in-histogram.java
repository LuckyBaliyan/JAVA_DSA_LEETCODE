class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int [] left = new int [n];
        int [] right = new int [n];

        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            st.pop();

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            st.pop();

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i = 0;i<n;i++){
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}