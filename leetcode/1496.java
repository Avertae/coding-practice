class Solution {
    public boolean isPathCrossing(String path) {
        Set<Long> set = new HashSet<>();
        long hash, inc = 1 << 14;
        int x = 0, y = 0;
        set.add((inc << 14) + inc);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                default: x--;
            }
            hash = (((long)x + inc) << 14) + y + inc;
            //dbg(x, y, hash, x + inc, ((long)x + inc) << 14);
            if (set.contains(hash)) return true;
            else set.add(hash);
        }
        return false;
    }

}