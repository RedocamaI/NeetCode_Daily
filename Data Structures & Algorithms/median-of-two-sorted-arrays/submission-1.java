class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] merged = new int[n+m];

        int k = 0, i = 0, j = 0;
        while(i < n && j < m) {
            int x = nums1[i];
            int y = nums2[j];

            if(x < y) {
                merged[k] = x;
                k++;
                i++;
                continue;
            }
            
            merged[k] = y;
            k++;
            j++;
        }

        while(i < n) {
            merged[k++] = nums1[i++];
        }

        while(j < m) {
            merged[k++] = nums2[j++];
        }

        if(merged.length % 2 == 1) {
            return (double)merged[merged.length / 2];
        }

        int ind1 = merged.length/2 - 1;
        int ind2 = merged.length/2;

        return (double)(merged[ind1] + merged[ind2])/(double)2;
    }
}
