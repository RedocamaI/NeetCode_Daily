class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, down = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        List<Integer> spiral = new ArrayList<>();
        while(up <= down && left <= right) {
            // upper boundary: left -> right
            for(int j=left;j<=right;j++) {
                spiral.add(matrix[up][j]);
            }
            up++;

            // right boundary: up -> down
            for(int i=up;i<=down;i++) {
                spiral.add(matrix[i][right]);
            }
            right--;

            // bottom boundary: right to left
            if(down < up)
                break;
            for(int j=right;j>=left;j--) {
                spiral.add(matrix[down][j]);
            }
            down--;

            // right boundary: bottom to top
            if(right < left)
                break;
            for(int i=down;i>=up;i--) {
                spiral.add(matrix[i][left]);
            }
            left++;
        }

        return spiral;
    }
}
