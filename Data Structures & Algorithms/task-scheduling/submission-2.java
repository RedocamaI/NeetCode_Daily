class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character task : tasks) {
            map.put(task, map.containsKey(task) ? 
                map.get(task) + 1 : 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        Deque<List<Integer>> dq = new ArrayDeque<>();

        int time = 0;
        while(!pq.isEmpty() || !dq.isEmpty()) {
            time++;
            int freq = pq.isEmpty() ? 0 : pq.peek();
            freq--;

            if(!pq.isEmpty())
                pq.poll();

            if(freq > 0)
                dq.offerLast(new ArrayList<>(List.of(freq, time+n)));
            
            if(!dq.isEmpty() && dq.peekFirst().get(1) == time) {
                int f = dq.peekFirst().get(0);
                pq.offer(f);
                dq.pollFirst();
            }
        }

        return time;
    }
}
