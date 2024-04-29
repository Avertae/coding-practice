class Solution {
    public boolean isRobotBounded(String instructions) {
        int dx = 0, dy = 0, curdir = 0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for (char c : instructions.toCharArray()) 
            switch (c) {
                case 'G': dx += dir[curdir][0]; dy += dir[curdir][1]; break;
                case 'L': curdir = (curdir + 3) % 4; break;
                default: curdir = (curdir + 1) % 4;
            }
        return dx == 0 && dy == 0 || curdir != 0;
    }
}