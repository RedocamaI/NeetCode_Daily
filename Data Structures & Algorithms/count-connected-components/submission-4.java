class Solution {
    int[] vis;
    private void traverse(int i, List<Integer>[] graph) {
        Queue<List<Integer>> bfs = new ArrayDeque<>();
        
        this.vis[i] = 1;
        bfs.offer(List.of(i, -1));
        while(!bfs.isEmpty()) {
            int node = bfs.peek().get(0);
            int parent = bfs.peek().get(1);
            bfs.poll();

            if(graph[node] == null)
                continue;

            for(int j=0;j<graph[node].size();j++) {
                int neighbor = graph[node].get(j);
                
                if(neighbor == parent)
                    continue;
                if(this.vis[neighbor] == 1)
                    continue;
                
                this.vis[neighbor] = 1;
                bfs.offer(List.of(neighbor, node));
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        this.vis = new int[n];

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


        int conComp = 0;
        for(int i=0;i<n;i++) {
            if(this.vis[i] == 1)
                continue;
            
            conComp++;
            traverse(i, graph);
        }

        return conComp;
    }
}
