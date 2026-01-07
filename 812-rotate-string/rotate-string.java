class Solution {
    public boolean rotateString(String s, String goal) {
        //return app1(s,goal);
        return app2(s,goal);
    }

    public static boolean app1(String s,String goal){
        int n = s.length();
        int m = goal.length();
       //Base case very important if both strings are not equal then we never had 2 equal strings.

       if(n != m)return false;

       if(s.equals(goal))return true;

       for(int i = 0;i<n-1;i++){
        String rot = s.substring(0,i+1);
        String rem = s.substring(i+1);
        String res = rem + rot;
        if(res.equals(goal))return true;
       }

       return false;
    }

    //0(1) Approach
    public static boolean app2(String s,String goal){
        int n = s.length();
        int m = goal.length();

        if(n != m)return false;
        if(s.equals(goal))return true;

        String res = s + s;
        return res.contains(goal);
    }
}