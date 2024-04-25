class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apples = 0, n = apple.length, m = capacity.length;
        for (int i = 0; i < n; i++)
            apples += apple[i];
        Arrays.sort(capacity);
        int boxes = 0, totalcap = 0, i = m - 1;
        while (i >= 0 && totalcap < apples) {
            totalcap += capacity[i];
            boxes++;
            i--;
        }
        return boxes;
    }
}