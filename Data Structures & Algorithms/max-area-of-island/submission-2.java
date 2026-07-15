class Solution {
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    private boolean isValid(int i, int j, int n, int m) {
        return !(
            i < 0 || j < 0 || i >= n || j >= m
        );
    }

    private int getArea(int i, int j, int[][] grid, int[][] vis) {
        vis[i][j] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int area = 1;

        for(int k=0;k<4;k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if(!isValid(ni, nj, n, m) || vis[ni][nj] == 1 || grid[ni][nj] == 0)
                continue;
            
            area += getArea(ni, nj, grid, vis);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j] == 1 || grid[i][j] == 0)
                    continue;
                
                maxArea = Math.max(maxArea, getArea(i, j, grid, vis));
            }
        }

        return maxArea;
    }
}
