class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i=0;i<pre.length;i++) {
            int a = pre[i][0];
            int b = pre[i][1];

            if(adj[b] == null) {
                adj[b] = new ArrayList<>();
            }

            adj[b].add(a);
            indegree[a]++;
        }

        Queue<Integer> bfs = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0)
                bfs.offer(i);
        }

        List<Integer> order = new ArrayList<>();
        while(!bfs.isEmpty()) {
            int course = bfs.peek();
            order.add(course);
            bfs.poll();

            if(adj[course] == null)
                continue;
            
            for(int i=0;i<adj[course].size();i++) {
                int depCourse = adj[course].get(i);
                indegree[depCourse]--;

                if(indegree[depCourse] == 0)
                    bfs.offer(depCourse);
            }
        }

        if(order.size() < numCourses)
            return new int[0];
        
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }
}
