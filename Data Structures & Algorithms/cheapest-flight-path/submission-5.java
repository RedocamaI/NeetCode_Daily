class Solution {
    public int findCheapestPrice(int n, 
    int[][] flights, int source, int dst, int k) {
        List<List<Integer>>[] graph = new ArrayList[n];
        for(int i=0;i<flights.length;i++) {
            int a = flights[i][0];
            int b = flights[i][1];
            int cost = flights[i][2];

            if(graph[a] == null)
                graph[a] = new ArrayList<>();
            
            graph[a].add(List.of(b, cost));
        }

        PriorityQueue<List<Integer>> bfs = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.get(0), b.get(0))
        );
        int[] cost = new int[n];

        Arrays.fill(cost, Integer.MAX_VALUE);
        bfs.offer(List.of(0, source, 0));
        while(!bfs.isEmpty()) {
            int stops = bfs.peek().get(0);
            int src = bfs.peek().get(1);
            int price = bfs.peek().get(2);
            
            bfs.poll();
            if(src == dst)
                continue;
            if(stops > k)
                continue;
            if(graph[src] == null)
                continue;

            for(int i=0;i<graph[src].size();i++) {
                int dest = graph[src].get(i).get(0);
                int currCost = graph[src].get(i).get(1);

                if(cost[dest] > currCost + price) {
                    bfs.offer(List.of(stops+1, dest, price + currCost));
                    cost[dest] = currCost + price;
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
