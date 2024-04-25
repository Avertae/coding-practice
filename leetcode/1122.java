class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        int[] result = new int[arr1.length];
        int idx = 0;
        for (int i : arr1) 
            map[i]++;
        for (int i : arr2)
            while (map[i]-- > 0)
                result[idx++] = i;
        for (int i = 0; i < map.length; i++)
            while (map[i]-- > 0)
                result[idx++] = i;
        return result;
    }
}