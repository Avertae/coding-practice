class Solution {

// O(n) DSU
/*    class DSU {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        public void add(int x) {
            parent.put(x, x);
            size.put(x, 1);
        }

        public int find(int x) {
            int px = parent.get(x);
            if (x != px) 
                parent.put(x, find(px));
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
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        var dsu = new DSU();
        var set = Arrays.stream(nums)
            .boxed()
            .collect(
                Collectors
                    .toCollection(HashSet::new)
            );
        for (int x : set) {
            if (!dsu.contains(x))
                dsu.add(x);
            if (dsu.contains(x - 1))
                dsu.union(x, x - 1);
            if (dsu.contains(x + 1))
                dsu.union(x, x + 1);
        }

        return dsu.maxUnion();
    }*/


// O(n) hash
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int max = 0, cur;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                cur = 1;
                int nextNum = num;
                while (set.contains(++nextNum)) {
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }

// O(n^2)
/*    class Union {
        int left;
        int right;

        Union(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "{" + this.left + "," + this.right + "}";
        }
    }


  
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        Set<Union> unions = new HashSet<>();
        Map<Integer, Union> leftMap = new HashMap<>();
        Map<Integer, Union> rightMap = new HashMap<>();
        for (var x : nums) {
            if (unions.stream().anyMatch(u -> u.left <= x && x <= u.right))
                continue;
            if (leftMap.containsKey(x + 1)) {
                int left = x;
                Union updated = leftMap.remove(x + 1);
                if (rightMap.containsKey(x - 1) && rightMap.get(x - 1) != updated) {
                    Union merged = rightMap.remove(x - 1);
                    leftMap.remove(merged.left);
                    unions.remove(merged);
                    left = merged.left;
                }
                updated.left = left;
                leftMap.put(left, updated);
            } else if (rightMap.containsKey(x - 1)) {
                int right = x;
                Union updated = rightMap.remove(x - 1);
                if (leftMap.containsKey(x + 1) && leftMap.get(x + 1) != updated) {
                    Union merged = leftMap.remove(x + 1);
                    rightMap.remove(merged.left);
                    unions.remove(merged);
                    right = merged.right;
                }
                updated.right = right;
                rightMap.put(right, updated);
            } else {
                Union newUnion = new Union(x, x);
                unions.add(newUnion);
                leftMap.put(x, newUnion);
                rightMap.put(x, newUnion);
            }
        }


        return unions.stream()
            .mapToInt(u -> u.right - u.left + 1)
            .max().getAsInt();
    } */

    void dbg(Object... s){ var o=System.out; int SIZE=20;
    for(Object z:s){
             if(z instanceof int[]){o.print("[");Arrays.stream((int[])z).limit(SIZE).forEach(x->o.print(x+","));if (((int[])z).length > 10) o.print("...");o.print("] ");}
        else if(z instanceof char[]){o.print("[[ch] "+new String((char[])z)+"] ");o.print("] ");}
        else if(z instanceof boolean[]){o.print("[[bool]");boolean[] bb=(boolean[])z;IntStream.range(0,Math.min(SIZE,bb.length)).mapToObj(i->bb[i]?'t':'f').forEach(o::print);o.print("] ");}
        else if(z instanceof Map){o.print("{");((Map)z).keySet().stream().limit(SIZE).map(k->k+"->"+((Map)z).get(k)+",").forEach(o::print);o.print("}\n");}
        else if(z instanceof Set) o.print(z+", ");
        else o.print(z+", ");
    }
    o.println();}
}
