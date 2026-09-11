class Solution {

    private boolean isCycle(List<Integer>[] graph, int[] vis, int root) {
        Queue<List<Integer>> bfs = new ArrayDeque<>();
        
        bfs.offer(List.of(root, -1));
        while(!bfs.isEmpty()) {
            int node = bfs.peek().get(0);
            int parent = bfs.peek().get(1);
            bfs.poll();

            if(graph[node] == null)
                continue;
            
            for(int i=0;i<graph[node].size();i++) {
                int neighbor = graph[node].get(i);

                if(neighbor == parent)
                    continue;
                if(vis[neighbor] == 1)
                    return true;
                
                vis[neighbor] = 1;
                bfs.offer(List.of(neighbor, node));
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        List<Integer>[] graph = new ArrayList[1001];

        for(int i=0;i<edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if(graph[a] == null)
                graph[a] = new ArrayList<>();
            if(graph[b] == null)
                graph[b] = new ArrayList<>();
            
            graph[a].add(b);
            graph[b].add(a);

            int[] vis = new int[1001];
            if(isCycle(graph, vis, a))
                return new int[]{a, b};
        }

        return new int[]{};
    }
}
