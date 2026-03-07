class Solution {
    public int minFlips(String s) {
        int n = s.length();

       // s = s+s; 
       //make up the string n + n to cover all type1 rotations
       //but we avoid making n+n string with modulo operator
        
        /* we can even optimize it with check alternate character at 
        each index inside inner loop
        
        StringBuilder s1 = new StringBuilder();    
        StringBuilder s2 = new StringBuilder();


        for(int i = 0;i<2*n;i++){
            s1.append((i%2 == 0? '0':'1'));
            s2.append((i%2 == 0? '1':'0'));
        }
        */

        int flip1 = 0;
        int flip2 = 0;
        int res  = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while(j<2*n){
            char expected1 = (j%2 == 0?'0':'1');
            char expected2 = (j%2 == 0?'1':'0');

            if(s.charAt(j % n) != expected1)flip1++;
            if(s.charAt(j % n) != expected2)flip2++;

            //when window size exceed n
            if(j-i+1>n){
                char expectedi1 = (i%2 == 0?'0':'1');
                char expectedi2 = (i%2 == 0?'1':'0');

                if(s.charAt(i % n)!= expectedi1)flip1--;
                if(s.charAt(i % n)!= expectedi2)flip2--;
                
                //finally move window 
                i++;
            }
 
            //when equals n i.e done 1 string comparison
            if(j-i+1 == n)res = Math.min(res,Math.min(flip1,flip2));

            j++;
        }

        return res;
    }
}