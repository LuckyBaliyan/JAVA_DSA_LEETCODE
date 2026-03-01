class Solution {
    public int minPartitions(String n) {
        int m = n.length();
        int ans = Integer.MIN_VALUE;

        for(int i = 0;i<m;i++){
            int maxDig = n.charAt(i) - '0';
            ans = Math.max(maxDig,ans);
        }

        return ans;
    }
}