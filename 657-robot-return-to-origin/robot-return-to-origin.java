class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();

        //just old damm class 10 concept find total displacement if 0 we are at (0,0)
        int displacementX = 0;
        int displacementY = 0;

        //Im marking U & L as +ve magnitudes of their axises
        for(char c:moves.toCharArray()){
            if(c == 'U')displacementY++;
            else if(c == 'D')displacementY--;
            
            if(c == 'L')displacementX++;
            else if(c == 'R')displacementX--;
        }

        //at the end check if both axis have 0 displacment so they are at their initial
        //given position A.T.Q (0,0)
        return displacementY  == 0 && displacementX == 0;
    }
}