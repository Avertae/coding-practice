class Solution {
    public boolean halvesAreAlike(String s) {
        //Set<Character> vowels = new HashSet<>(Set.of('a','u','e','i','o'));
        int n2 = s.length() / 2, i = 0, sum1 = 0, sum2 = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'i' || c == 'o' || c == 'u' || c =='e') // 5ms
            //if (vowels.contains(c))  // 7ms
                if (i < n2) sum1++;
                else sum2++;
            i++;
        }
        return sum1 == sum2;
    }
}