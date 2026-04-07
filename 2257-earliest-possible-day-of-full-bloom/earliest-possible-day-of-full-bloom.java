class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        //make a piar of plantTime and growTime based array
        int [][] arr = new int [n][2];

        for(int i = 0;i<n;i++){
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }

        //sort on the basis of growTime
        Arrays.sort(arr,(a,b)-> b[1] - a[1]);

        int maxBlom = Integer.MIN_VALUE;
        int currDay = 0;

        for(int i = 0; i< n;i++){
            currDay += arr[i][0];
            maxBlom = Math.max(maxBlom, currDay + arr[i][1]);
        }

        return maxBlom;
    }
}