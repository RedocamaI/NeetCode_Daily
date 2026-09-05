class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<pre.length;i++) {
            int a = pre[i][0];
            int b = pre[i][1];

            if(adj[b] == null)
                adj[b] = new ArrayList<>();
            
            adj[b].add(a);
            indegree[a]++;
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        int counter = 0;

        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0)
                bfs.offer(i);
        }

        while(!bfs.isEmpty()) {
            int course = bfs.peek();
            bfs.poll();
            counter++;

            if(adj[course] == null)
                continue;
            
            for(int i=0;i<adj[course].size();i++) {
                int depCourse = adj[course].get(i);
                indegree[depCourse]--;

                if(indegree[depCourse] == 0)
                    bfs.offer(depCourse);
            }
        }

        return counter == numCourses;
    }
}
