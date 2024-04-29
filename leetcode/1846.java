class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int cur = 1, n = arr.length, result;
        for (int i = 1; i < n; i++)
            if (arr[i] > cur) cur++;
        return cur;
    }
}