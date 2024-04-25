class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2002];
        int delta = 1000;
        for (int i : arr)
            map[i+delta]++;
        int[] map2 = new int[1001];
        for (int i : map) 
            if (i != 0) {
                map2[i]++;
                if (map2[i] > 1) return false;
            }
        return true;
    }
}