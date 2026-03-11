class Solution {
    public int bitwiseComplement(int n) {
        // O(n), O(n)
        // return approach1(n);

        //O(log n) , O(1)
        return approach2(n);
    }

    public static int approach2(int n){
        //edge case
        if(n==0)return 1;

        int counter = 0;
        int res = 0;

        while(n>0){
           int r = n % 2;
           res += Math.pow(2,counter) * ((r == 0)?1:0);
           n = n/2;
           counter++;
        }

        return  res;
    }

    public static int approach1(int n){
          String binary = Integer.toBinaryString(n);

        StringBuilder sb = new StringBuilder();

        //build 1's comp string of the binaryString
        for(char ch:binary.toCharArray()){
            if(ch == '0')sb.append('1');
            else sb.append('0');
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}