class Solution {
    public String removeTrailingZeros(String num) {
        int pos = num.length() - 1;
        while (pos > 0 && num.charAt(pos) == '0') pos--;
        return num.substring(0, pos + 1);
    }
}