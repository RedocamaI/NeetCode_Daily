class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int l = 0, h = n-1;
        while(l <= h) {
            int mid = (l-h)/2 + h;
            if(target == matrix[mid][0])
                return true;
            
            if(target > matrix[mid][0])
                l = mid+1;
            else if(target < matrix[mid][0])
                h = mid-1;
        }

        if(h < 0)
            return false;
        
        int ind = h;
        l = 0;
        h = matrix[ind].length - 1;
        while(l <= h) {
            int mid = (l-h)/2 + h;
            if(target == matrix[ind][mid])
                return true;
            
            if(target > matrix[ind][mid])
                l = mid+1;
            else if(target < matrix[ind][mid])
                h = mid-1;
        }

        return false;
    }
}
