class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            int frequency = map.getOrDefault(ch, 0) + 1;
            map.put(ch, frequency);
        }

        for(char ch:t.toCharArray()) {
            if(!map.containsKey(ch))
                return false;
            
            int frequency = map.getOrDefault(ch, 0) - 1;
            map.put(ch, frequency);
        }

        for(Map.Entry<Character, Integer>entry : map.entrySet()) {
            if(entry.getValue() > 0)
                return false;
        }

        return true;
    }
}
