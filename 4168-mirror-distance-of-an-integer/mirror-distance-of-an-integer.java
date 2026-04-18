class Solution {
    
    public static int rev(int n){
        int rev = 0;
        while(n > 0){
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        return rev;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - rev(n));
    }
}