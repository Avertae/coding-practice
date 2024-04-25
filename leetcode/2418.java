class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        // 8ms
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) 
            idx[i] = i;
        Arrays.sort(idx, (i, j) -> Integer.compare(heights[i], heights[i]));
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[idx[i]];
        }
        return result;

        // 14ms
        /*return IntStream
                .range(0, heights.length)
                .boxed() 
                .sorted(Comparator.comparing(i-> heights[i], Comparator.reverseOrder()))
                .map(i -> names[i])
                .toArray(String[]::new);*/
    }
}