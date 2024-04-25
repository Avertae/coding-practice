class Solution {
    public String generateTheString(int n) {
        if (n == 1) return "a";
        if (n == 2) return "ab";
        StringBuilder result = new StringBuilder(n).repeat("a", n-2);
        if (n % 2 == 0) result.append("ab");
        else result.append("bc");
        return result.toString();
    }
}