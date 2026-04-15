class Solution {
    public boolean isPowerOfTwo(int n) {
        /*if(n <= 0)return false;

        while(n%2 == 0){
            n = n / 2;
        }

        return n == 1;*/

         // all pow of 2 has only 1 set bit from behind i.e 0000010
        //Bit manupulation mask of n & (n - 1)
       //(n - 1) alternate the digits till last set bits 

       //ex- 00001000 AND 000000 == 0
       // ex-2 00001100 AND 00001011 == 000010000 so not
       return (n > 0 && ((n&(n - 1)) == 0));
    }
}