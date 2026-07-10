class Solution {
    int getMinHours(int speed, int[] piles) {
        int hours = 0;
        int n = piles.length;

        for(int i=0;i<n;i++) {
            int numOfBananas = piles[i];
            hours = hours + (int)Math.ceil(numOfBananas/(double)speed);
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        int low = 1;
        int n = piles.length;

        for(int i=0;i<n;i++) {
            high = Math.max(high, piles[i]);
            low = Math.min(low, piles[i]);
        }

        int minSpeed = high;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int hours = getMinHours(mid, piles);
            
            if(hours <= h) {
                minSpeed = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return minSpeed;
    }
}
