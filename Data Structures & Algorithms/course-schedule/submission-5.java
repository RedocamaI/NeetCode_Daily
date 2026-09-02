class Solution {
    private boolean isCyclic(int i, 
    List<Integer>[] adjList, int[] vis, int[] pathVis) {
        vis[i] = 1;
        pathVis[i] = 1;
        if(adjList[i] == null) {
            pathVis[i] = 0;
            return false;
        }

        for(int j=0;j<adjList[i].size();j++) {
            int neighbour = adjList[i].get(j);

            if(pathVis[neighbour] == 1)
                return true;
            
            if(vis[neighbour] == 0) {
                if(isCyclic(neighbour, adjList, vis, pathVis))
                    return true;
            }
        }

        pathVis[i] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] pre) {
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        List<Integer>[] adjList = new ArrayList[numCourses];

        for(int i=0;i<pre.length;i++) {
            int course = pre[i][0];
            int preCourse = pre[i][1];

            if(adjList[preCourse] == null)
                adjList[preCourse] = new ArrayList<>();

            adjList[preCourse].add(course);
        }

        for(int i=0;i<numCourses;i++) {
            if(vis[i] == 1)
                continue;
            
            if(isCyclic(i, adjList, vis, pathVis))
                return false;
        }

        return true;
    }
}
