class Solution {
    int n, m;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};

    private boolean isValid(int i, int j) {
        return !(
            i < 0 || i >= this.n || j < 0 || j >= this.m
        );
    }

    private void traverse(int i, int j, char[][] board) {
        board[i][j] = 'Y';

        for(int x=0;x<4;x++) {
            int ni = i + di[x];
            int nj = j + dj[x];

            if(!isValid(ni, nj) || 
                board[ni][nj] == 'Y' ||
                board[ni][nj] == 'X')
                continue;
            
            traverse(ni, nj, board);
        }
    }

    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;

        // upper boundary:
        for(int j=0;j<m;j++) {
            if(board[0][j] == 'X' || board[0][j] == 'Y')
                continue;
            
            traverse(0, j, board);
        }

        // left boundary:
        for(int i=0;i<n;i++) {
            if(board[i][0] == 'X' || board[i][0] == 'Y')
                continue;
            
            traverse(i, 0, board);
        }
        
        // bottom boundary:
        for(int j=0;j<m;j++) {
            if(board[n-1][j] == 'X' || board[n-1][j] == 'Y')
                continue;
            
            traverse(n-1, j, board);
        }

        // right boundary:
        for(int i=0;i<n;i++) {
            if(board[i][m-1] == 'X' || board[i][m-1] == 'Y')
                continue;
            
            traverse(i, m-1, board);
        }

        // reinstate the board with only unsurrounded zeros:
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
}
