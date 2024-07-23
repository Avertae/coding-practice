class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] minusTarget = Arrays.stream(nums)
            .map(x -> target - x)
            .sorted()
            .toArray();
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        int resultNum1 = -1, resultNum2 = -1;
        for (int x : minusTarget)
            if (Arrays.binarySearch(sortedNums, x) >= 0) {
                resultNum1 = x;
                resultNum2 = target - x;
                break;
            }

        int[] result = {-1, -1};
        for (int i = 0; i < n; i++) {
            if (nums[i] == resultNum1 && result[0] == -1 && i != result[1])
                result[0] = i;
            if (nums[i] == resultNum2 && result[1] == -1 && i != result[0]) 
                result[1] = i;
            if (result[0] != -1 && result[1] != -1)
                break;
        }
        return result;
    }

}
