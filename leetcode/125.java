class Solution {

    public boolean isPalindrome(String s) {
        int[] chars = s.toLowerCase().chars()
            .filter(c -> 'a' <= c && c <= 'z' || '0' <= c && c <= '9')
            .toArray();
        for (int i = 0; i < chars.length / 2; i++)
            if (chars[i] != chars[chars.length - i - 1])
                return false;
        return true;
    }
}
