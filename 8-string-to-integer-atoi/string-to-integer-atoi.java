class Solution {
    public int myAtoi(String s) {
       String numString = s.trim();
       int n  = numString.length();

       if(n == 0)return 0;

       long res = 0;
       int  neg = (numString.charAt(0) == '-')?1:0;
       int pos = (numString.charAt(0) == '+')?1:0;

       //Range offsets as question askes to return max and min interger 
       // ranges if overflows or out of index range

       int MIN = Integer.MIN_VALUE;
       int MAX = Integer.MAX_VALUE;

       for(int i = Math.max(pos,neg);i<n;i++){
          char ch = numString.charAt(i);
          if(Character.isDigit(ch)){
              int digit = ch - '0';

                // EARLY OVERFLOW CHECK
                if (res > MAX / 10 || (res == MAX / 10 && digit > 7)) {
                    return neg == 1 ? MIN : MAX;
                }

                res = (res * 10) + digit;
          }
          else break;
       } 

       res = neg == 0?res:-1*res;
       if(res > MAX)return MAX;
       else if (res < MIN)return MIN;

       return (int) res;
    }
}