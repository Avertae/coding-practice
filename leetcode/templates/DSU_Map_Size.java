    class DSU_Map_Size {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        public void add(int x) {
            parent.put(x, x);
            size.put(x, 1);
        }

        public int find(int x) {
            int px = parent.get(x);
            if (x != px) {
                px = find(px);
                parent.put(x, px);
            }
            return px;
        }

        public boolean contains(int x) {
            return parent.containsKey(x);
        }

        public void union(Integer x, Integer y) {
            if (!contains(x) || !contains(y))
                return;

            x = find(x);
            y = find(y);

            if (x == y)
                return;

            int sx = size.get(x);
            int sy = size.get(y);
            if (sx < sy) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent.put(y, x);
            size.put(x, sx + sy);
        }

        public int size(int x) {
            return size.get(x);
        }

        public int maxUnion() {
            return parent.keySet().stream()
                .mapToInt(x -> size(find(x)))
                .max()
                .orElse(0);
        }

        public Collection<Set<Integer>> disjointSets() {
            var map = new HashMap<Integer, Set<Integer>>();
            parent.keySet().forEach(i -> {
                var key = find(i);
                var set = map.getOrDefault(key, new HashSet<Integer>());
                set.add(i);
                map.putIfAbsent(key, set);
            });
            return map.values();
        }
    }
