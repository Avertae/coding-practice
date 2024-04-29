class Solution {
    public double averageWaitingTime(int[][] customers) {

        long sum = 0, pos = 0;
        for (int[] c : customers) {
            if (pos < c[0])
                pos = c[0];
            else 
                sum += pos - c[0];

            sum += c[1];
            pos += c[1];

            //dbg(sum);
        }
        return sum / (double)customers.length;

    }

}