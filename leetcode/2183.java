class Solution {

    int moveDivisableToRight(int[] arr, int k) {
        int moved = 0, n = arr.length;
        for (int i = 0; i < n-moved; i++) 
            if (arr[i] % k == 0) {
                while (i < n-moved-1 && arr[n-moved-1] % k == 0) moved++;
                int tmp = arr[i];
                arr[i] = arr[n-moved-1];
                arr[n-moved-1] = tmp;
                moved++;
            }
        return moved;
    }

    Map<Integer, Integer> factorize(int num) {
        int j, orig = num;
        Map<Integer, Integer> result = new HashMap<>();
        while (num % 2 == 0) {
            result.put(2, result.getOrDefault(2, 0) + 1);
            num /= 2;
        }
        j = 3;
        while (j <= Math.sqrt(num) + 1) {
            if (num % j == 0) {
                result.put(j, result.getOrDefault(j, 0) + 1);
                num /= j;
            } else {
                j += 2;
            }
        }
        if (num > 1) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }

        /*num = 1;
        for (Integer i : result.keySet())
            for(j = 1; j <= result.get(i); j++)
                num *= i;
        
        assert num == orig;*/

        return result;
    }

    long sumOfProgression(int min, int max) {
        return (min + max) * (max - min + 1) / 2;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        long result = 0l;

        /*
        int moved;
        if (k == 1) 
            return sumOfProgression(1, n-1);

        moved = moveDivisableToRight(nums, k);
        result += sumOfProgression(n-moved, n-1);*/

        Map<Integer, Long> gcdCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curgcd = gcd(nums[i], k);
            for (int storedgcd : gcdCount.keySet())
                if ((long)curgcd * storedgcd % k == 0) {
                    result += gcdCount.get(storedgcd);
                }
            gcdCount.put(curgcd, gcdCount.getOrDefault(curgcd, 0L) + 1L);
        }

        // [TLE] approach #1  bruteforcing factor difference calculation 
        /*List<Map<Integer, Integer>> factorized = new ArrayList<>();
        for (int i = 0; i < n-moved; i++) {
            factorized.add(factorize(nums[i]));
        }

        Map<Integer, Integer> kf = factorize(k);

        for (int i = 0; i < n-moved-1; i++) 
            outer:
            for (int j = i+1; j < n-moved; j++) {
                for (Integer ki : kf.keySet()) {
                    if (factorized.get(i).getOrDefault(ki, 0) 
                        + factorized.get(j).getOrDefault(ki, 0)
                        - kf.get(ki) < 0) {
                        continue outer;
                    }
                }

            }*/

        // [TLE] approach #2  using 1-by-1 addition for each combined gcd match
        /*for (int i = 0; i < n-moved-1; i++) 
            outer:
            for (int j = i+1; j < n-moved; j++) {

                if (gcds[i] > 1 && gcds[j] > 1 && (gcds[i] * gcds[j]) % k == 0)
                    result++;
            }*/

        return result;
    }

}