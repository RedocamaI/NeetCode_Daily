class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1)
            return true;
        
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if(graph[a] == null)
                graph[a] = new ArrayList<>();
            if(graph[b] == null)
                graph[b] = new ArrayList<>();
            
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=0;i<n;i++) {
            if(graph[i] == null)
                return false;
        }
        
        // cycle detection in ug(undirected-graph):
        Queue<List<Integer>> bfs = new ArrayDeque<>();
        int[] vis = new int[n];

        vis[0] = 1;
        bfs.offer(List.of(0, -1));
        while(!bfs.isEmpty()) {
            int node = bfs.peek().get(0);
            int parent = bfs.peek().get(1);
            bfs.poll();
            
            for(int i=0;i<graph[node].size();i++) {
                int neighbour = graph[node].get(i);
                
                if(neighbour == parent)
                    continue;
                if(vis[neighbour] == 1)
                    return false;
                
                vis[neighbour] = 1;
                bfs.offer(List.of(neighbour, node));
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i] == 0)
                return false;
        }

        return true;
    }
}
