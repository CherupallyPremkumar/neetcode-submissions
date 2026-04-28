class TimeMap {

   

    private Map<String,TreeMap<Integer,String>> keyMap;


    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!keyMap.containsKey(key)){
            return "";
        }

        TreeMap<Integer,String> result = keyMap.get(key);
        Map.Entry<Integer,String> entry=result.floorEntry(timestamp);
        return (entry == null) ? "" : entry.getValue();
        
    }
}
