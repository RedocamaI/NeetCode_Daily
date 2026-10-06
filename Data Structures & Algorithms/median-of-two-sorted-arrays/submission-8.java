class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int x = n+m;

        if(n > m)
            return findMedianSortedArrays(nums2, nums1);
        
        int t = (x+1)/2;
        int l = 0, h = n;
        while(l <= h) {
            int mid1 = l + (h-l)/2;
            int mid2 = t - mid1;

            int l1 = mid1 >= 1 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 >= 1 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1 < n ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < m ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 > r2) {
                h = mid1-1;
                continue;
            }

            if(l2 > r1) {
                l = mid1+1;
                continue;
            }

            if(x%2 == 1) {
                return Math.max(l1, l2);
            }

            int a = Math.max(l1, l2);
            int b = Math.min(r1, r2);
            double val = (double)((a + b) / (double)2);
            
            return val;
        }

        return 0;
    }
}
