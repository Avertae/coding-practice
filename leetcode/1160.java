class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cword = new int[26], cchars = new int[26];
        int sum = 0;
        for (char c : chars.toCharArray()) cchars[c-'a']++;
        outer:
        for (String word : words) {
            Arrays.fill(cword, 0);
            for (char c : word.toCharArray()) cword[c-'a']++;
            for (int i = 0; i < 26; i++)
                if (cchars[i] - cword[i] < 0) continue outer;
            sum += word.length();
        }
        return sum;
    }
}