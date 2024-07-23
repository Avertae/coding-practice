class Solution {

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
