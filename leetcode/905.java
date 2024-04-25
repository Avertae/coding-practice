class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // 1ms
        int n = nums.length, idx = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (i < n && nums[i] % 2 != 0) i++;
            if (i < n) result[idx++] = nums[i];
            else break;
        }
        for (int i = 0; i < n; i++) {
            while (i < n && nums[i] % 2 != 1) i++;
            if (i < n) result[idx++] = nums[i];
            else break;
        }
        return result;

        // 10ms
        /*return Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return Integer.compare(i % 2, j % 2);
            }
        }).mapToInt(x->x).toArray();*/
    }
}