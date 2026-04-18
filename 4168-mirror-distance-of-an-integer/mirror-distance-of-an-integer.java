class Solution {

    //TC :- at max O(10) --> O(1)
    public static int rev(int n){
        int rev = 0;
        while(n > 0){
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        return rev;
    }

    // TC : - O(1)
    public int mirrorDistance(int n) {
        return Math.abs(n - rev(n));
    }
}