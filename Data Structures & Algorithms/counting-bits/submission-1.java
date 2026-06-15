class Solution {
    public int getNumBits(int num) {
        int bits = 0;
        while(num > 0) {
            bits += (num & 1);
            num >>= 1;
        }

        return bits;
    }
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++) {
            int numBits = getNumBits(i);
            arr[i] = numBits;
        }

        return arr;
    }
}
