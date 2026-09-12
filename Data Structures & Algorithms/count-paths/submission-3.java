class Solution {
    public int uniquePaths(int n, int m) {
        int[] cur = new int[m];

        Arrays.fill(cur, 1);

        for(int i=n-2;i>=0;i--) {
            int[] next = new int[m];
            next[m-1] = 1;

            for(int j=m-2;j>=0;j--) {
                next[j] = cur[j] + next[j+1];
            }

            cur = next;
        }

        return cur[0];
    }
}
