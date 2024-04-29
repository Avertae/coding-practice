class FrequencyTracker {

    Map<Integer, Integer> numbers;
    Map<Integer, Integer> freqs;

    public FrequencyTracker() {
        this.numbers = new HashMap<>();
        this.freqs = new HashMap<>();
    }
    
    public void add(int number) {
        Integer freq = numbers.getOrDefault(number, 0);
        if (freq > 0) 
            this.freqs.put(freq, this.freqs.get(freq) - 1);
        this.freqs.put(freq + 1, this.freqs.getOrDefault(freq + 1, 0) + 1);
        this.numbers.put(number, freq + 1);
    }
    
    public void deleteOne(int number) {
        Integer freq = this.numbers.getOrDefault(number, 0);
        if (freq > 0) {
            Integer ffreq = this.freqs.get(freq);
            if (ffreq > 0)
                this.freqs.put(freq, ffreq - 1);
            if (freq > 1)
                this.freqs.put(freq - 1, this.freqs.get(freq - 1) + 1);
            this.numbers.put(number, freq - 1);
        }
    }
    
    public boolean hasFrequency(int frequency) {
        //dbg(frequency, numbers, freqs);
        return this.freqs.containsKey(frequency) 
                && this.freqs.get(frequency) > 0;
    }

}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */