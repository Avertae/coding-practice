class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0;
        for(String word : sentence.split(" ")) {
            i++;
            if (word.startsWith(searchWord))
                return i;
        }
        return -1;
    }
}