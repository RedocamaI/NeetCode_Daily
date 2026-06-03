class KthLargest {

    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for(int num : nums) {
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        int k = this.k - 1;
        int ans = 0;
        List<Integer> list = new ArrayList<>();

        while(k-- > 0) {
            list.add(pq.poll());
        }

        ans = pq.peek();
        for(int num:list) {
            pq.add(num);
        }

        return ans;
    }
}
