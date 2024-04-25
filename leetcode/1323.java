class Solution {
    public int maximum69Number (int num) {
        // 1ms
        /*StringBuilder sb = new StringBuilder(Integer.toString(num));
        int i = sb.indexOf("6");
        if (i >= 0) sb.setCharAt(i, '9');
        return Integer.parseInt(sb.toString());*/

        // 0ms
        int add = 0, curadd = 3, i = num;
        while (i > 0) {
            if (i % 10 == 6)
                add = curadd;
            curadd *= 10;
            i /= 10;
        }
        return num + add;
    }
}