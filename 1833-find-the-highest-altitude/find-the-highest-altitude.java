class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int [] prefix = new int [n+1];
        prefix[0] = gain[0];

        for(int i = 1; i<n; i++){
           prefix[i] = prefix[i-1] + gain[i];
        }

        int maxHeight = -1;
        for(int p : prefix){
            maxHeight = Math.max(maxHeight, p);
        }

        return maxHeight < 0 ? 0 : maxHeight;
    }
}