class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = nums.length;

        for(int i=0;i<n;i++) {
            if(minHeap.size() == k) {
                int val = minHeap.peek();
                if(nums[i] > val) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
                continue;
            }
            minHeap.offer(nums[i]);
        }

        return minHeap.peek();
    }
}
