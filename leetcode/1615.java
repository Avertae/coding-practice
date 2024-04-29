class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] counts = new int[n];

        // 4ms
        boolean[][] roadmap = new boolean[n][n];
        // 30ms 
        /*Map<Integer, Set<Integer>> roadmap = new HashMap<>();*/
        for (int[] road : roads) {
            counts[road[0]]++;
            counts[road[1]]++;

            /*if (!roadmap.containsKey(road[0]))
                roadmap.put(road[0], new HashSet<>());
            roadmap.get(road[0]).add(road[1]);
            if (!roadmap.containsKey(road[1]))
                roadmap.put(road[1], new HashSet<>());
            roadmap.get(road[1]).add(road[0]);*/

            roadmap[road[0]][road[1]] = true;
            roadmap[road[1]][road[0]] = true;
        }

        int max = 0, cur = 0;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                cur = counts[i] + counts[j];
                /*if (roadmap.get(i) != null && roadmap.get(i).contains(j)) {*/
                if (roadmap[i][j]) 
                    cur--;
                max = Math.max(cur, max);
                //dbg(i, j, max);
            }
        }
        //dbg(counts);
        return max;
    }

}