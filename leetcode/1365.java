class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        // 6ms
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) 
            idx[i] = i;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return Integer.compare(nums[i], nums[j]);
            }
        };
        Arrays.sort(idx, comparator);

        // 10ms
        /*int[] idx = IntStream.range(0, n)
            .mapToObj(value -> Integer.valueOf(value))
            .sorted((i1, i2) -> Integer.compare(nums[i1], nums[i2]))
            .mapToInt(value -> value.intValue())
            .toArray();*/

        int[] result = new int[n];
        int cur = -1, curAmt = 0;
        for (int i = 0; i < n; i++) {
            if (cur != nums[idx[i]]) {
                cur = nums[idx[i]];
                curAmt = i;
            }
            result[idx[i]] = curAmt;
        }
        return result;
    }
}