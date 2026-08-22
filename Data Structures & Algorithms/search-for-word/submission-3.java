class Solution {
    int n;
    int m;
    int l;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};
    char[][] board;
    String word;

    boolean isValid(int i, int j) {
        return !(
            i < 0 || i >= this.n || j < 0 || j >= this.m 
        );
    }

    boolean wordExists(int i, int j, int ind, int[][] vis) {
        if(ind >= this.l)
            return true;

        boolean exists = false;
        for(int k=0;k<4;k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if(!isValid(ni, nj) || vis[ni][nj] == 1)
                continue;
            if(this.board[ni][nj] != this.word.charAt(ind))
                continue;
            
            vis[ni][nj] = 1;
            exists |= wordExists(ni, nj, ind+1, vis);
            
            // backtracking: mark them un-visited
            // so you can explore them again in a different path.
            vis[ni][nj] = 0;
        }

        return exists;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.n = board.length;
        this.m = board[0].length;
        this.l = word.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] vis = new int[n][m];

                    vis[i][j] = 1;
                    if (wordExists(i, j, 1, vis))
                        return true;
                }
            }
        }

        return false;
    }
}
