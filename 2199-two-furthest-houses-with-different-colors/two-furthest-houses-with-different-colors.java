class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        int [] pair1 = new int [] {colors[0], 0}; //pick first from  left
        int [] pair2 = new int [2]; //pick different from right

        for(int i = n - 1; i>=0; i--){
           if(pair1[0] != colors[i]){
             pair2[0] = colors[i];
             pair2[1] = i;
             break;
           }
        }

        maxDist = Math.max(maxDist, Math.abs(pair1[1] - pair2[1]));

        int [] pair3 = {colors[n-1], n-1};
        int [] pair4 = new int [2];

        for(int i = 0; i<n; i++){
            if(pair3[0] != colors[i]){
                pair4[0] = colors[i];
                pair4[1] = i;
                break;
            }
        } 

        maxDist = Math.max(maxDist, Math.abs(pair3[1] - pair4[1]));
        return maxDist;
    }
}