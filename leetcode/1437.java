class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int min = 100001, amt = 100001, cur = -1;
        for (int i = 0; i < nums.length; i++) {
            while (cur == -1 && i < nums.length && nums[i] == 0) i++;
            if (i == nums.length) return true;
            if (cur != nums[i]) {
                if (cur == 1 && amt > 1) return false;
                if (cur == 0 && amt < k) return false;
                cur = nums[i];
                amt = 0;
            }
            amt++;
        }
        return true;
    }
}