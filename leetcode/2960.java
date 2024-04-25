class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int result = 0, n = batteryPercentages.length;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > result)
                result++;
        }
        return result;
    }
}