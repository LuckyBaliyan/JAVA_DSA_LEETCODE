class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;

        Arrays.sort(beans);

        long sum = 0;
        for(int i =0;i<n;i++){
            sum += beans[i];
        }

        long ans = sum;

        for(int i = 0;i<n;i++){
            long currSum  = sum - (long) (n-i)*beans[i];
            if(currSum < ans)ans = currSum;
        }

        return ans;
    }
}