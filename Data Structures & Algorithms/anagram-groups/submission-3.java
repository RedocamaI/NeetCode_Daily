class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        for(String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!dict.containsKey(sorted)) {
                dict.put(sorted, new ArrayList<>());
            }
            dict.get(sorted).add(str);
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
