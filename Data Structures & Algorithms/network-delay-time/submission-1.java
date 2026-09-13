class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer>>[] graph = new ArrayList[n+1];
        PriorityQueue<List<Integer>> bfs = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.get(0), b.get(0))
        );
        int[] time = new int[n+1];

        for(int i=0;i<times.length;i++) {
            int a = times[i][0];
            int b = times[i][1];
            int t = times[i][2];

            if(graph[a] == null)
                graph[a] = new ArrayList<>();
            
            graph[a].add(List.of(b, t));
        }
        Arrays.fill(time, Integer.MAX_VALUE);
        
        time[k] = 0;
        bfs.offer(List.of(0, k));
        while(!bfs.isEmpty()) {
            int node = bfs.peek().get(1);
            int t = bfs.peek().get(0);
            bfs.poll();

            if(graph[node] == null)
                continue;

            for(int i=0;i<graph[node].size();i++) {
                int neighbor = graph[node].get(i).get(0);
                int timeToReach = graph[node].get(i).get(1);

                if(t + timeToReach >= time[neighbor])
                    continue;
                
                time[neighbor] = t + timeToReach;
                bfs.offer(List.of(time[neighbor], neighbor));
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            ans = Math.max(ans, time[i]);
        }

        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
