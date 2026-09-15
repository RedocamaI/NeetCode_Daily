class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] vis = new int[n];
        PriorityQueue<List<Integer>> bfs = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.get(0), b.get(0))
        );

        int cost = 0;
        bfs.offer(List.of(0, 0, -1));
        while(!bfs.isEmpty()) {
            int node = bfs.peek().get(1);
            int d = bfs.peek().get(0);
            int parent = bfs.peek().get(2);
            bfs.poll();

            if(vis[node] == 1)
                continue;
            
            vis[node] = 1;
            cost += d;
            for(int i=0;i<n;i++) {
                if(vis[i] == 1 || i == parent)
                    continue;
                
                int curCost = Math.abs(points[node][0] - points[i][0]) +
                    Math.abs(points[node][1] - points[i][1]);
                
                bfs.offer(List.of(curCost, i, node));
            }
        }

        return cost;
    }
}
