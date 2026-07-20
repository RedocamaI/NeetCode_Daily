class Solution {
    boolean checkRows(char[][] board) {
        for(int i=0;i<9;i++) {
            int[] nums = new int[10];
            for(int j=0;j<9;j++) {
                if(board[i][j] == '.')
                    continue;

                int ind = board[i][j] - '0';
                if(nums[ind] > 0)
                    return false;

                nums[ind] = 1;
            }
        }

        return true;
    }

    boolean checkCols(char[][] board) {
        for(int j=0;j<9;j++) {
            int[] nums = new int[10];
            for(int i=0;i<9;i++) {
                if(board[i][j] == '.')
                    continue;
                
                int ind = board[i][j] - '0';
                if(nums[ind] > 0)
                    return false;
                
                nums[ind] = 1;
            }
        }

        return true;
    }

    boolean checkGrids(char[][] board) {
        int i=0;
        while(i < 7) {
            int j = 0;
            while(j < 7) {
                int n = i+3;
                int m = j+3;
                int[] nums = new int[10];
                for(int x=i;x<n;x++) {
                    for(int y=j;y<m;y++) {
                        if(board[x][y] == '.')
                            continue;
                        
                        int ind = board[x][y] - '0';
                        if(nums[ind] > 0)
                            return false;
                        
                        nums[ind] = 1;
                    }
                }

                j+=3;
            }

            i+=3;
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean rowsValid = checkRows(board);
        if(!rowsValid)
            return false;

        boolean colsValid = checkCols(board);
        if(!colsValid)
            return false;
        
        boolean gridsValid = checkGrids(board);
        return gridsValid;
    }
}
