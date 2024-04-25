class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {

        // 2ms
        /*List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
            if (words[i].indexOf(x) >= 0)
                result.add(i);
        return result;*/

        // 2ms
        return IntStream
                .range(0, words.length)
                .filter(i -> words[i].indexOf(x) >= 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
