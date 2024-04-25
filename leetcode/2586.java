class Solution {
    public static final String VOWELS = "aeiou";
    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++)
            if (VOWELS.indexOf(words[i].charAt(0)) >= 0 
                && VOWELS.indexOf(words[i].charAt(words[i].length() - 1)) >= 0)
                result++;
        return result;
    }
}