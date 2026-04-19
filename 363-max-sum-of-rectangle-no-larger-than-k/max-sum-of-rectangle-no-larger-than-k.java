class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = 1; j<m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        for(int start = 0; start < m; start++){
            for(int end = start; end < m; end++){
                TreeSet<Integer> st = new TreeSet<>();
                st.add(0);

                int prefixSum = 0;

                //scan each column
                for(int i = 0; i<n; i++){
                   int sum = matrix[i][end];

                   if(start > 0){
                    sum -= matrix[i][start - 1];
                   }

                   prefixSum += sum;

                   //find the nearest sum <= k
                   Integer target = st.ceiling(prefixSum - k);

                   if(target != null){
                    ans = Math.max(ans, prefixSum - target);
                   }

                   st.add(prefixSum);
                }
            }
        }

        return ans;
    }
}