

class TimeMap {
    HashMap<String, HashMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new HashMap<>());
        }
        timeMap.get(key).put(timestamp, value);

    }
    
    public String get(String key, int timestamp) {
        int latestTime = -1;
        if(!timeMap.containsKey(key)) return "";
        HashMap<Integer, String> tempMap = timeMap.get(key);
        String value = "";
        
        for(int timeStamps : tempMap.keySet()){
            if(timeStamps <= timestamp && timeStamps > latestTime){
                latestTime = timeStamps;
            }
        }
        if(latestTime != -1) value = timeMap.get(key).get(latestTime);
        
        return value;
        
    }
}
