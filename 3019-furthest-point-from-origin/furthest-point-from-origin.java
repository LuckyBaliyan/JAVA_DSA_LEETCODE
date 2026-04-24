class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n  = moves.length();
        int countL = 0;
        int countR = 0;

        for(char ch: moves.toCharArray()){
            if(ch == 'L')countL++;
            if(ch == 'R')countR++;
        }

        char trend = countL > countR ? 'L' : 'R';

        int dis = 0;

        for(char ch : moves.toCharArray()){
            if(ch == trend || ch == '_')dis++;
            else dis--;
        }

        return dis;
    }
}