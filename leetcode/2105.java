class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int ac = capacityA, bc = capacityB, sum = 0;
        if (n == 1) return 0;
        for (int i = 0; i < n / 2; i++) {
            int a = plants[i], b = plants[n - 1 - i];
            if (ac < a) {
                sum++;
                ac = capacityA;
            }
            if (bc < b) {
                sum++;
                bc = capacityB;
            }
            ac -= a;
            bc -= b;
        }
        //dbg(sum);
        if (n % 2 == 1) {
            int val = plants[n / 2];
            if (ac < val && bc < val)
                sum++;
        }
        //dbg('x',sum);

        return sum;
    }

}