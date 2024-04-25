class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < n-indexDifference; i++)
            for (int j = i+indexDifference; j < n; j++)
                if (j-i >= indexDifference 
                        && Math.abs(nums[i]-nums[j]) >= valueDifference) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                    }
        result[0] = result[1] = -1;
        return result;
    }
}