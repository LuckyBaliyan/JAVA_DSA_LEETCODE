class Solution {
    static ArrayList<String> happy;
    public String getHappyString(int n, int k) {
        happy = new ArrayList<>();
        generate(n,-1,"",'$');

        int size = happy.size();
        if(k > size)return "";

        //sortStrings lexicographically
        Collections.sort(happy);

        return happy.get(k - 1);
    }

    public static void generate(int n,int idx,String curr,char lastUsed){
        if(idx == n-1){
            happy.add(curr);
            return;
        }

        //generate from a
        if(lastUsed != 'a')generate(n,idx+1,curr+"a",'a');
        
        //generate from b
        if(lastUsed != 'b')generate(n,idx+1,curr+"b",'b');

        //generate from c
        if(lastUsed != 'c')generate(n,idx+1,curr+"c",'c');
    }
}