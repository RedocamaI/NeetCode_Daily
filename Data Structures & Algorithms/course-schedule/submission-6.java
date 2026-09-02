class Solution {

    boolean isCycle(int i, int[] vis, int[] pathVis, List<Integer>[] adj) {
        vis[i] = 1;
        pathVis[i] = 1;
        if(adj[i] == null) {
            pathVis[i] = 0;
            return false;
        }

        for(int j=0;j<adj[i].size();j++) {
            int neighbour = adj[i].get(j);

            if(pathVis[neighbour] == 1)
                return true;
            
            if(vis[neighbour] == 0) {
                if(isCycle(neighbour, vis, pathVis, adj))
                    return true;
            }
        }

        pathVis[i] = 0;
        return false;
    }

    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] adj = new ArrayList[n];

        int m = pre.length;
        for(int i=0;i<m;i++) {
            int course = pre[i][0];
            int preCourse = pre[i][1];

            if(adj[preCourse] == null) {
                adj[preCourse] = new ArrayList<>();
            }

            adj[preCourse].add(course);
        }

        int[] vis = new int[n];
        int[] pathVis = new int[n];

        for(int i=0;i<n;i++) {
            if(vis[i] == 1)
                continue;
            
            if(isCycle(i, vis, pathVis, adj))
                return false;
        }

        return true;
    }
}
