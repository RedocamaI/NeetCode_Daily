class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0)
            return 0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++) {
            maxHeap.add(stones[i]);
        }

        while(!maxHeap.isEmpty()) {
            int stoneX = maxHeap.poll();

            if(maxHeap.isEmpty())
                return stoneX;
            
            int stoneY = maxHeap.poll();
            int fusionStone = stoneX == stoneY ? 
                0 : (stoneX > stoneY ? stoneX - stoneY : stoneY - stoneX);
            
            if(fusionStone == 0)
                continue;

            maxHeap.add(fusionStone);
        }

        return 0;
    }
}
