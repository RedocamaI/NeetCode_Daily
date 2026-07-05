class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        while(i < n/2) {
            int x = i;
            int y = n-i-1;
            
            for(int j=0;j<n;j++) {
                int temp = matrix[x][j];
                matrix[x][j] = matrix[y][j];
                matrix[y][j] = temp;
            }

            i++;
        }

        for(i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
