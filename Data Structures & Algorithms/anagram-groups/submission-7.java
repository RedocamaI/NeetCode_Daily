class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for(String str:strs) {
            int[] freq = new int[26];
            String key = "";
            for(int i=0;i<str.length();i++) {
                int ind = (str.charAt(i) - 97);
                freq[ind]++;
            }

            for(int f:freq) {
                key = key + (char)f;
            }

            if(!dict.containsKey(key)) {
                dict.put(key, new ArrayList<>());
            }
            dict.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : dict.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();

            ans.add(values);
        }

        return ans;
    }
}
