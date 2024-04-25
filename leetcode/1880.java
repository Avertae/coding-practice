class Solution {

    int getIntFromChars(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 10;
            result += s.charAt(i) - 'a';
        }
        return result;
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getIntFromChars(firstWord) 
                + getIntFromChars(secondWord) == getIntFromChars(targetWord);
    }
}