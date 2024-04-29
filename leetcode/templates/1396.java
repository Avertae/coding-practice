class UndergroundSystem {

    // {stationName} -> {totalTime, travelCount}
    Map<String, List<Integer>> history;
    Map<Integer, Entry> status;

    static class Entry {
        String stationName;
        int time;
        Entry(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    public UndergroundSystem() {
        this.history =  new HashMap<>();
        this.status = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        status.put(id, new Entry(stationName, t));
    }

    private String generatePath(String s1, String s2) {
        return s1 + "|" + s2;
    }
    
    public void checkOut(int id, String stationName, int t) {
        Entry entry = status.get(id);
        String path = generatePath(entry.stationName, stationName);
        List<Integer> hist = history.get(path);
        if (hist == null) 
            hist = Arrays.asList(0, 0);
        hist.set(0, hist.get(0) + t - entry.time);
        hist.set(1, hist.get(1) + 1);
        history.put(path, hist);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<Integer> stat = history.get(generatePath(startStation, endStation));
        return (double) stat.get(0) / stat.get(1);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */