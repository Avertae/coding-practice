class Solution {
    public int sumOfMultiples(int n) {

        // 3ms
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                result +=i;
        }
        return result;

        // 8ms
        /*return IntStream
                .range(1, n + 1)
                .filter(i -> i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                .sum();*/
    }
}