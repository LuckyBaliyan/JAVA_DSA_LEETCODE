class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistanceRight = Integer.MAX_VALUE;
        int minDistanceLeft = Integer.MAX_VALUE;

        //lets specify max search range == starIndex + n i.e back to searchIndex
        // again we can also take 2 * n like search the complete circle
        for(int i = startIndex; i < startIndex + n; i++){
            int effectiveIndx = i % n;
            if(words[effectiveIndx].equals(target)){
                minDistanceRight = i - startIndex;
                //i used beacuse toatl steps not the diffrence of indices
                break;
            }
        }
        
        for(int i = startIndex; i > startIndex - n; i--){
            int effectiveIndx = (i + n) % n;
            // safe gaurd the range to manage -ve index out of bounds
            if(words[effectiveIndx].equals(target)){
                minDistanceLeft = startIndex - i;
                break;
            }
        }


        int ans =  Math.min(minDistanceLeft, minDistanceRight);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}