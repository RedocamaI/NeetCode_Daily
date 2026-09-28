class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int comp = Integer.compare(b.get(0), a.get(0));

                if(comp != 0)
                    return comp;
                
                return Integer.compare(b.get(1), a.get(1));
            }
        );

        for(int r=0;r<n;r++) {
            maxHeap.offer(List.of(nums[r], r));

            int maxVal = maxHeap.peek().get(0);
            int ind = maxHeap.peek().get(1);
            while(!maxHeap.isEmpty() && ind <= r-k) {
                maxHeap.poll();
                ind = maxHeap.peek().get(1);
                maxVal = maxHeap.peek().get(0);
            }

            if(maxHeap.size() >= k) {
                ans.add(maxVal);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
