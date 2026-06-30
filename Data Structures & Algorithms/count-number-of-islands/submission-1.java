class Solution {
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    public boolean isValid(int i, int j, int n, int m) {
        return !(
            i < 0 || i >= n || j < 0 || j >= m
        );
    }

    public void traverseIsland(int i, int j, int n, int m, 
    int[][] vis, char[][] grid) {
        vis[i][j] = 1;

        for(int k=0;k<4;k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if(isValid(ni, nj, n, m) == false
            || grid[ni][nj] == '0' 
            || vis[ni][nj] == 1)
                continue;
            
            traverseIsland(ni, nj, n, m, vis, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        int numIslands = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j] == 0 && grid[i][j] == '1') {
                    numIslands++;
                    traverseIsland(i, j, n, m, vis, grid);
                }
            }
        }

        return numIslands;
    }
}
