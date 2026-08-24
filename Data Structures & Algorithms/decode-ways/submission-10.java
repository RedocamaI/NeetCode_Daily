class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)-'0' == 0)
            return 0;
        
        int n = s.length();
        
        int prev = 0;
        int cur = 1;
        for(int i=n-1;i>=0;i--) {
            int val = s.charAt(i) - '0';
            if(val == 0){
                prev = cur;
                cur = 0;
                continue;
            }

            int take1 = cur;
            int take2 = 0;
            if(i <= n-2 && val <= 2) {
                int nextVal = s.charAt(i+1) - '0';

                if(val == 1 || (
                    (val == 2 && nextVal < 7))
                )
                    take2 = prev;
            }

            int next = take1 + take2;
            prev = cur;
            cur = next;
        }

        return cur;
    }
}
