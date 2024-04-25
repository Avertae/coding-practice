class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> src = new HashSet<>(), dst = new HashSet<>();
        for (List<String> path : paths) {
            src.add(path.get(0));
            dst.add(path.get(1));
        }
        dst.removeAll(src);
        return dst.iterator().next();
    }
}