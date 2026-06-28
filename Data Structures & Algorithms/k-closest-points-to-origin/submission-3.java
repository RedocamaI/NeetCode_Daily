class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(
            (list1, list2) -> Double.compare(list1[0], list2[0])
        );


        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distanceFromOrigin = Math.sqrt(
                Math.pow(x, 2) + Math.pow(y, 2)
            );

            minHeap.add(new double[]{distanceFromOrigin, x, y});
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(i < k) {
            ans[i][0] = (int) minHeap.peek()[1];
            ans[i][1] = (int) minHeap.peek()[2];

            minHeap.poll();
            i++;
        }

        return ans;
    }
}
