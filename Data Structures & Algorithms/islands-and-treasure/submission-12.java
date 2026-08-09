class Cell {
    int i;
    int j;
    int d;

    Cell(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.d = d;
    }

    int getRow() {
        return this.i;
    }

    int getCol() {
        return this.j;
    }

    int getDist() {
        return this.d;
    }
}

class Solution {
    int inf = Integer.MAX_VALUE;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};

    private boolean isValid(int i, int j, int n, int m) {
        return !(
            i < 0 || i >= n || j < 0 || j >= m
        );
    }

    private void traverse(int i, int j, 
    int n, int m, int[][] vis, int[][] grid) {
        Queue<Cell> bfs = new ArrayDeque<>();

        bfs.offer(new Cell(i, j, 0));
        vis[i][j] = 1;
        while(!bfs.isEmpty()) {
            Cell cell = bfs.peek();
            int r = cell.getRow();
            int c = cell.getCol();
            int d = cell.getDist();

            bfs.poll();

            int dist = d + 1;
            for(int k=0;k<4;k++) {
                int nr = r + di[k];
                int nc = c + dj[k];

                if(!isValid(nr, nc, n, m) || 
                grid[nr][nc] == -1 || 
                grid[nr][nc] == 0 || 
                vis[nr][nc] == 1)
                    continue;
                if(grid[nr][nc]+1 < 0)
                    grid[nr][nc] = dist;
                if(grid[nr][nc]+1 > 0)
                    grid[nr][nc] = Math.min(grid[nr][nc], dist);
                
                vis[nr][nc] = 1;
                bfs.offer(new Cell(nr, nc, grid[nr][nc]));
            }
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] != 0)
                    continue;
                
                int[][] vis = new int[n][m];
                traverse(i, j, n, m, vis, grid);
            }
        }
    }
}
