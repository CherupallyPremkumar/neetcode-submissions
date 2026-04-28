class TimeMap {

    private Map<String,List<Data>> keyMap;

    class Data{
        int time;
        String val;
        Data(int time,String val){
            this.time = time;
            this.val = val;
        }
    }

    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
       if (!keyMap.containsKey(key)) return "";
        
        List<Data> list = keyMap.get(key);
        return binarySearch(list, timestamp);
        
    }
    private String binarySearch(List<Data> list, int target) {
        int left = 0, right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).time <= target) {
                // This is a potential candidate, but there might be 
                // a larger timestamp closer to target on the right.
                res = list.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
