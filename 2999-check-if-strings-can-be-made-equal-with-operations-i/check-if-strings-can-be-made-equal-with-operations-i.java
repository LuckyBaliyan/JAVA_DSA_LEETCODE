class Solution {
    public boolean canBeEqual(String s1, String s2) {
       /* boolean zeroTo2 = ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2)
        == s2.charAt(2)) || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) 
        == s2.charAt(0)));

        boolean oneTo3 = ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) ==
        s2.charAt(3)) || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) ==
        s2.charAt(1)));

        return zeroTo2 && oneTo3;
        */

        //Approach 2 

        int [] even = new int [26];
        int [] odd = new int [26];

        for(int i = 0;i<4;i++){
           if(i % 2 == 0){
            even[s1.charAt(i) - 'a']++;
            even[s2.charAt(i) - 'a']--;
           }
           else{
            odd[s1.charAt(i) - 'a']++;
            odd[s2.charAt(i) - 'a']--;
           }
        }

        for(int i = 0;i<26;i++){
            if(even[i] != 0 || odd[i] != 0)return false;
        }

        return true;
    }
}