class Solution {
    public String mergeAlternately(String word1, String word2) {
        boolean word1Bigger = word1.length() > word2.length();
        int mixlen = word1Bigger ? word2.length() : word1.length();
        StringBuilder result = new StringBuilder(word1.length() + word2.length());
        for (int i = 0; i < mixlen; i++)
            result.append(word1.charAt(i)).append(word2.charAt(i));
        String suffix = word1Bigger ? word1.substring(mixlen) : word2.substring(mixlen);
        result.append(suffix);
        return result.toString();
    }
}