class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int n = s.length();
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < n; i++) {
            chars.put(s.charAt(i), chars.getOrDefault(s.charAt(i), 0) + 1);
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Integer i : chars.values()) {
            if (i != 0)
                return false;
        }
        return true;
    }

}
