class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minTime = Math.max(Math.abs(fy - sy), Math.abs(fx - sx));
        return (sx == fx && sy == fy) ? t != 1 : minTime <= t;
    }
}