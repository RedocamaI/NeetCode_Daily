class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] result = new int[n];

        int j = n-1;
        for(int i=n-2;i>=0;i--) {
            int val = temp[i];
            while(j < n && temp[j] <= val) {
                if(result[j] == 0) {
                    j = n;
                    break;
                }

                j += result[j];
            }

            if(j == n) {
                result[i] = 0;
                j = i;
                continue;
            }

            result[i] = j-i;
            j = i;
        }

        return result;
    }
}
