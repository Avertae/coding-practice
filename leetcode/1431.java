class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 0-1ms
        int n = candies.length, max = 0;
        for (int i = 0; i < n; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            result.add(candies[i] + extraCandies >= max);
        return result;

        // 2ms
        /*int n = candies.length;
        final int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(i -> i + extraCandies >= max).collect(Collectors.toList());*/
    }
}