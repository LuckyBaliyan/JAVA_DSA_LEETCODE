class Solution {
    public int bitwiseComplement(int n) {
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