class Data {
    private String value;
    private int timestamp;

    Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    int getTimestamp() {
        return this.timestamp;
    }

    String getValue() {
        return this.value;
    }
}

class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).add(new Data(value, timestamp));
            return;
        }

        map.put(key, new ArrayList<>(List.of(
            new Data(value, timestamp))
        ));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        
        List<Data> data = map.get(key);
        int l = 0, h = data.size() - 1;
        String ans = "";

        while(l <= h) {
            int mid = l + (h-l)/2;
            if(data.get(mid).getTimestamp() <= timestamp) {
                ans = data.get(mid).getValue();
                l = mid+1;
            }else
                h = mid-1;
        }

        return ans;
    }
}
