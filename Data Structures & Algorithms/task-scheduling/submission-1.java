class Solution {
    public int leastInterval(char[] tasks, int n) {
        int l = tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character task:tasks) {
            map.put(task, map.containsKey(task) ? map.get(task)+1 : 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> q = new ArrayDeque<>();

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            time++;
            int f = !pq.isEmpty() ? pq.peek() : 0;
            f--;

            if(!pq.isEmpty())   pq.poll();
            if(f > 0)   q.offerLast(new int[]{f, time+n});

            if(!q.isEmpty() && q.peekFirst()[1] == time) {
                pq.offer(q.peekFirst()[0]);
                q.pollFirst();
            }
        }

        return time;
    }
}
