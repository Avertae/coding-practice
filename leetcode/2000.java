class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int split = word.indexOf(ch);
        if (split >= 0) {
            return sb
                .append(word.substring(0, split + 1))
                .reverse()
                .append(word.substring(split + 1))
                .toString();
        } else return word;
    }
}