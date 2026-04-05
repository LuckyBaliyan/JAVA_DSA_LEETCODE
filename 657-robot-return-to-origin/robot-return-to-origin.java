class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();

        int displacementX = 0;
        int displacementY = 0;

        for(char c:moves.toCharArray()){
            if(c == 'U')displacementY++;
            else if(c == 'D')displacementY--;
            
            if(c == 'L')displacementX++;
            else if(c == 'R')displacementX--;
        }

        return displacementY  == 0 && displacementX == 0;
    }
}