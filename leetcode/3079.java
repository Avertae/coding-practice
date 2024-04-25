class Solution {

    int encrypt(int a) {
        int result = 0, max = 0, amt = 0;
        while (a != 0) {
            int digit = a % 10;
            if (digit > max)
                max = digit;
            a /= 10;
            amt++;
        }
        for (int i = 0; i < amt; i++) {
            result *= 10;
            result += max;
        }
        return result;
    }

    public int sumOfEncryptedInt(int[] nums) {
        int result = 0;
        for (int i : nums) 
            result += encrypt(i);
        return result;
    }
}