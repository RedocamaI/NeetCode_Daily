class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> array = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num:nums) {
            Integer freq = map.get(num);
            if(freq == null) {
                map.put(num, 1);
                continue;
            }

            map.put(num, freq+1);
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            array.add(new ArrayList<>(List.of(entry.getKey(), entry.getValue())));
        }
        
        array.sort(Comparator.comparing(innerArray -> innerArray.get(1)));
        Collections.reverse(array);
        int[] ans = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] = array.get(i).get(0);
        }

        return ans;
    }
}
