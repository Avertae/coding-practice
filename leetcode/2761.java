class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        int amt = 0;
        boolean[] primeMask = new boolean[n];


        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            int cur = i * 2;
            while (cur < n) {
                if (!primeMask[cur]) {
                    amt++;
                    primeMask[cur] = true;
                }
                cur += i;
            }
            //dbg(primeMask, i, cur);
        }

        /*int[] primes = new int[m - amt];
        primes[0] = 2;
        //Set<Integer> primes = new LinkedHashSet<>();
        //primes.add(2);
        int cur = 1;
        for (int i = 1; i < m; i++) {
            if (!primeMask[i]) {
                primes[cur] = (i << 1) + 1;
                //primes.add((i << 1) + 1);
                cur++;
            }
        }*/

        //dbg(primes);

        List<List<Integer>> ret = new ArrayList<>();
        /*for (Integer i : primes) {
            if (i > m) continue;
            if (primes.contains(n - i)) {
                ret.add(List.of(i, n - i));
            }
        }*/

        int i = 2, i2;
        while (i <= n / 2) {
            if (!primeMask[i] && !primeMask[n - i])
                ret.add(List.of(i, n - i));
            i++;
        }

        return ret;

    }
void dbg(Object... s){ var o=System.out; int SIZE=20;
    for(Object z:s){
             if(z instanceof int[]){o.print("[");Arrays.stream((int[])z).limit(SIZE).forEach(x->o.print(x+","));if (((int[])z).length > 10) o.print("...");o.print("] ");}
        else if(z instanceof char[]){o.print("[[ch] "+new String((char[])z)+"] ");o.print("] ");}
        else if(z instanceof boolean[]){o.print("[[bool]");boolean[] bb=(boolean[])z;IntStream.range(0,Math.min(SIZE,bb.length)).mapToObj(i->bb[i]?'t':'f').forEach(o::print);o.print("] ");}
        else if(z instanceof Map){o.print("{");((Map)z).keySet().stream().limit(SIZE).map(k->k+"->"+((Map)z).get(k)+",").forEach(o::print);o.print("} ");}
        else o.print(z+", ");
    }
    o.println();}

}