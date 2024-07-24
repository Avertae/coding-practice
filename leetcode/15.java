class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<String> uniq = new HashSet<>();
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first - 1] == nums[first])
                continue;
            int second = first + 1;
            int third = n - 1;
            int minusFirst = -nums[first];
            while (second < third) {
                int secondThirdSum = nums[second] + nums[third];
                if (secondThirdSum < minusFirst)
                    second++;
                else if (secondThirdSum > minusFirst)
                    third--;
                else {
                    // slow uniq check
                    /*String concat = new StringBuilder()
                        .append(nums[first])
                        .append(' ')
                        .append(nums[second])
                        .append(' ')
                        .append(nums[third])
                        .toString();
                    if (!uniq.contains(concat)) {
                        result.add(List.of(nums[first], nums[second], nums[third]));
                        uniq.add(concat);
                    }*/
                    result.add(List.of(nums[first], nums[second], nums[third]));
                    while (++second < third && nums[second - 1] == nums[second]);
                    while (--third > second && nums[third + 1] == nums[third]);
                }
            }
        }
        return result;
    }
}
