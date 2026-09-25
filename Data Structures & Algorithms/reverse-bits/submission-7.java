class Solution {
    public int reverseBits(int n) {
        int num = n;
        int val = 0;

        for(int i=0;i<32;i++) {
            int setBit = num & 1;

            if(setBit == 1) {
                val = val | (1 << (31 - i));
            }

            // unsigned right shift:
            num >>>= 1;
        }

        return val;
    }
}
