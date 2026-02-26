class Solution {
    public int numSteps(String s) {
        /*long num = Long.parseLong(s,2);
        int steps = 0;

        while(num != 1){
            if(num % 2 != 0)num = num + 1;
            else num /= 2;

            steps++;
        }

        return  steps;
        */

        int n = s.length();
        int carry = 0;
        int steps = 0;

        for(int i = n - 1;i>0;i--){
           int lastNum = s.charAt(i) - '0';
           //gives either 0 or 1 
           if(lastNum + carry == 1){
            steps += 2;
            carry = 1;
           }
           else{
            steps++;
           }
        }

        return steps + carry;
    }
}