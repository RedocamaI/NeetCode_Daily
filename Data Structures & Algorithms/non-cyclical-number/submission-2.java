class Solution {
    public boolean isHappy(int n) {
        int num = n;
        Map<Integer, Integer> map = new HashMap<>();

        int val = num;
        while(true) {
            int sum = 0;
            while(val > 0) {
                sum += Math.pow(val%10, 2);
                val = val/10;
            }

            val = sum;
            if(val == 1)
                break;
            
            if(map.containsKey(val))
                return false;
            map.put(val, 1);
        }

        return true;
    }
}
