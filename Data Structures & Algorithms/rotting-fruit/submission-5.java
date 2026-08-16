class Solution {
    private int time;
    private int[] di = new int[]{-1, 0, 1, 0};
    private int[] dj = new int[]{0, -1, 0, 1};

    private boolean isValid(int i, int j, int n, int m) {
        return !(
            i < 0 || i >= n || j < 0 || j >= m
        );
    }

    private void getMinTime(int i, int j, 
    int[][] grid, int[][] rottingTimes) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Deque<int[]> bfs = new ArrayDeque<>();

        bfs.offer(new int[]{i, j, 0});
        vis[i][j] = 1;
        while(!bfs.isEmpty()) {
            int r = bfs.peek()[0];
            int c = bfs.peek()[1];
            int t = bfs.peek()[2];
            bfs.poll();

            for(int k=0;k<4;k++) {
                int nr = r + di[k];
                int nc = c + dj[k];
                if(!isValid(nr, nc, n, m) || 
                    grid[nr][nc] == 0 ||
                    grid[nr][nc] == 2 ||
                    vis[nr][nc] == 1)
                    continue;
                
                bfs.offer(new int[]{nr, nc, t+1});
                vis[nr][nc] = 1;
                rottingTimes[nr][nc] = Math.min(rottingTimes[nr][nc], t+1);
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        List<int[]> rottens = new ArrayList<>();
        this.time = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int fresh = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        
        if(fresh == 0)
            return 0;
        if(rottens.size() == 0)
            return -1;

        int[][] rottingTimes = new int[n][m];
        for(int i=0;i<n;i++) {
            Arrays.fill(rottingTimes[i], 1000);
        }

        // only go for the originally rotten oranges:
        for(int i=0;i<rottens.size();i++) {
            getMinTime(
                rottens.get(i)[0], rottens.get(i)[1], 
                grid, rottingTimes
            );
        }

        // check if all fruits have rotten:
        int time = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && rottingTimes[i][j] == 1000)
                    return -1;
                
                if(grid[i][j] == 1) {
                    time = Math.max(time, rottingTimes[i][j]);
                }
            }
        }

        return time;
    }
}
