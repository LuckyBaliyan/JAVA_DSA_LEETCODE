class Solution {
    public int[] countBits(int n) {
        int [] arr = new int [n+1];

        arr[0] = 0;
        for(int i=1;i<=n;i++){
            int half = i/2;
            int last = i%2;
            arr[i] = arr[half] + last;
        }

        return arr;
    }
}