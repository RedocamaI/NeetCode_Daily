class Solution {
    public int reverse(int x) {
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }

        if(x < 0) {
            int val = reverse(Math.abs(x));
            if(val < 0)
                return 0;
            
            return -1*val;
        }
        
        int num = x;
        int rev = 0;
        int k = 0;
        while(num > 0) {
            int d = num%10;
            
            rev = rev*10 + d;
            if(rev % 10 != d)
                return 0;
            
            k++;
            num /= 10;
        }

        return rev;
    }
}
