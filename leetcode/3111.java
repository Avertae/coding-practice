class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] xx = new int[points.length];
        for (int i = 0; i < points.length; i++)
            xx[i] = points[i][0];
        Arrays.sort(xx);
        int result = 0, lastx = -w-1;
        for (int x : xx) {
            if (x > lastx) {
                result++;
                lastx = x + w;
            }
        }
        return result;
    }
}