class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long result, max = 0;
        for (int i = 0; i < n; i++) {
            result = heights[i];
            int prev = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] > prev)
                    result += prev;
                else {
                    result += heights[j];
                    prev = heights[j];
                }
            }
            prev = heights[i];
            for (int j = i + 1; j < n; j++) {
                if (heights[j] > prev)
                    result += prev;
                else {
                    result += heights[j];
                    prev = heights[j];
                }
            }
            max = Math.max(max, result);
        }
        return max;
    }
}