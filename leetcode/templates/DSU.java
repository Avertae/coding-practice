    class DSU {
        int[] parent;
        int[] size;
        int[] rank;

        public DSU(int n) {
            rank = new int[n + 1];
            size = new int[n + 1];
            parent = new int[n + 1];
            for(int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int px = parent[x];
            if (x != px) {
                px = find(px);
                parent[x] =px;
            }
            return px;
        }

        public void unionSize(int x, int y) {

            x = find(x);
            y = find(y);

            if (x == y)
                return;

            int sx = size[x];
            int sy = size[y];
            if (sx < sy) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            size[x] = sx + sy;
        }

        public void unionRank(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (rank[px] > rank[py]) 
                parent[py] = px;
            else if (rank[px] < rank[py]) 
                parent[px] = py;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }

        public int size(int x) {
            return size[x];
        }

        public int maxUnion() {
            return Arrays.stream(parent)
                .map(x -> size[find(x)])
                .max()
                .orElse(0);
        }

        public Collection<Set<Integer>> disjointSets() {
            var map = new HashMap<Integer, Set<Integer>>();
            Arrays.stream(parent).forEach(i -> {
                var key = find(i);
                var set = map.getOrDefault(key, new HashSet<Integer>());
                set.add(i);
                map.putIfAbsent(key, set);
            });
            return map.values();
        }
    }
