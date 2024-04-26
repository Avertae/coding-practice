class Solution {
    public int[] evenOddBit(int n) {
        int esum = 0, osum = 0;
        boolean evencnt = true;
        int[] result = new int[2];
        while (n > 0) {
            evencnt = !evencnt;
            if (n % 2 == 1) if (evencnt) osum++; else esum++;
            n /= 2;
        }
        result[1] = osum;
        result[0] = esum;
        return result;
    }
}