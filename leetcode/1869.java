class Solution {
    public boolean checkZeroOnes(String s) {
        int n = s.length(), max1 = 0, max0 = 0, amt = 0;
        char cur = 0;
        for (char c : s.toCharArray()) {
            if (cur != c) {
                if (cur == '0') { if (amt > max0) max0 = amt; }
                else if (amt > max1) max1 = amt;
                amt = 1;
                cur = c;
            } else amt++;
        }
        if (cur == '0') { if (amt > max0) max0 = amt; }
        else if (amt > max1) max1 = amt;
        return max1 > max0;
    }

}