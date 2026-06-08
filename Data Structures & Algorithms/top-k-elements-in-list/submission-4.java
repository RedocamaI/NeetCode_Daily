class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
            Comparator.comparingInt((List<Integer> list) -> list.get(0)).reversed()
        );
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
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            maxHeap.add(List.of(value, key));
        }

        for(int i=0;i<k;i++) {
            if(!maxHeap.isEmpty()) {
                Integer val = maxHeap.poll().get(1);
                ans[i] = val;
            }
        }

        return ans;
    }
}
