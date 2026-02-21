class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left;i<=right;i++){
            if(containsPrimeBits(Integer.toBinaryString(i)))ans++;
        }

        return ans;
    }

    static boolean containsPrimeBits(String s){
        int setBits = 0;

        for(char num:s.toCharArray()){
            if(num == '1')setBits++;
        }

        if(setBits == 2 || setBits == 3 || setBits == 5 ||
        setBits == 7 || setBits == 11 || setBits == 13 || setBits == 17
        || setBits == 19 )return true;

        return false;
    }
}