class Solution {
    public int minimumDeletions(String s) {
        int bs = 0;
        int minCost = 0;

        for(char ch:s.toCharArray()){
            if(ch == 'b')bs++;
            if(bs > 0 && ch == 'a')minCost++;

            minCost = Math.min(minCost,bs);
        }

        return minCost;
    }
}