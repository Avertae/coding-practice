class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1, max = 0;
        while (l < r) {
            int lh = height[l], rh = height[r];
            max = Math.max(max, Math.min(lh, rh)*(r - l));
            if (lh < rh)
                l++;
            else if (lh > rh)
                r--;
            else {
                l++; r--;
            }
        }
        return max;
    }
}
