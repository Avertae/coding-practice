    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        public void makeSet(int i) {
            parent.put(i, i);
            size.put(i, 1);
        }

        public Integer findSet(int i) {
            if (!parent.keySet().contains(i)) {
                return null;
            }
            if (parent.get(i) == i) {
                return i;
            }

            parent.put(i, findSet(parent.get(i)));
            return parent.get(i);
        }

        public void unionSet(int i, int j) {
            i = findSet(i);
            j = findSet(j);
            if (size.get(i) < size.get(j)) {
                int tmp = i;
                i = j;
                j = tmp;
            }

            parent.put(j, i);
            size.put(i, size.get(i) + size.get(j));
        }
    }
