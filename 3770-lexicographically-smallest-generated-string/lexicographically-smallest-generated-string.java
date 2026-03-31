class Solution {
    public static boolean isSame(char [] word, String str2, int i, int m){
        for(int j = 0;j<m;j++){
            if(word[i] != str2.charAt(j))return false;
            i++;
        }

        return true;
    }
    public String generateString(String str1, String str2) {
        int n  = str1.length();
        int m = str2.length();

        int N = n + m - 1;

        int [] canChange = new int [N];
        char[] word = new char[N];
        java.util.Arrays.fill(word, '$');

        //Start filling with True condition as we have to satisfy this
        //at any cost 
        for(int i = 0;i<n;i++){
           if(str1.charAt(i)  == 'T'){
                int i_ = i;
                for(int j = 0;j<m;j++){
                    if(word[i_] != '$' && word[i_] != str2.charAt(j)){
                        return "";
                    }

                    word[i_] = str2.charAt(j);
                    i_++;
                }
           }
        }

        //filling up the empty space greedly with 'a' to get smallest possible string
        for(int i = 0;i<N;i++){
           if(word[i] == '$'){
            word[i] = 'a';
            canChange[i] = 1; // we can change it because it's our place value
           }
        }

        //verify the F index are being correctly filled in the word
        for(int i = 0;i<n;i++){
            if(str1.charAt(i) == 'F'){

                if(isSame(word,str2,i,m)){
                    boolean change = false;
                    for(int k = i+m-1; k>= i; k--){
                        if(canChange[k] == 1){
                           word[k] = 'b'; // if not a then b is the sec smallest choice
                           change = true;
                           break;
                        }
                    }

                    if(!change)return "";
                }
            }
        }

        return new  String(word);
    }
}