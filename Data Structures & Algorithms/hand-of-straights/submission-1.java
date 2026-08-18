class Solution {
    int[] map;
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        int numGrps = n/groupSize;
        
        this.map = new int[10001];
        Arrays.sort(hand);

        for(int val : hand) {
            this.map[val]++;
        }

        // forming each group:
        int numEls = 0;
        while(numGrps-- > 0) {
            int start = 0;
            for(int i=0;i<=10000;i++) {
                if(map[i] > 0) {
                    start = i;
                    map[start]--;
                    break;
                }
            }
            numEls = 1;

            int cur = start+1;
            while(numEls < groupSize) {
                if(map[cur] == 0)
                    return false;
                
                // include the current element
                map[cur]--;
                numEls++;

                // move to next element:
                cur++;
            }
        }

        for(int i=0;i<=10000;i++) {
            if(map[i] > 0)
                return false;
        }

        return true;
    }
}
