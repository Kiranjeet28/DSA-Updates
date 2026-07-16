import java.lang.Math;

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        return Math.abs(recursion(moves, 0, 0));
    }

    public int recursion(String moves, int i, int pos) {
        // base case
        if (i == moves.length()) return pos;

        char ch = moves.charAt(i);

        if (ch == 'L') {
            return recursion(moves, i + 1, pos - 1);
        } 
        else if (ch == 'R') {
            return recursion(moves, i + 1, pos + 1);
        } 
        else { // '_'
            int takeL = recursion(moves, i + 1, pos - 1);
            int takeR = recursion(moves, i + 1, pos + 1);

            return Math.abs(takeL) > Math.abs(takeR) ? takeL : takeR;
        }
    }
}
