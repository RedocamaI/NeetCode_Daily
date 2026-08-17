class Solution {
    int ans;
    private void createPal(int i, int j, String s) {
        int n = s.length();
        if(i >= 0 && j < n) {
            if(s.charAt(i) == s.charAt(j))
                this.ans++;
        }

        if(i > 0 && j < n-1) {
            if(s.charAt(i) == s.charAt(j)) {
                createPal(i-1, j+1, s);
            }
        }
    }

    public int countSubstrings(String s) {
        int n = s.length();
        this.ans = 0;
        for(int i=0;i<n;i++) {
            createPal(i, i, s);
        }
        
        for(int i=1;i<n;i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                createPal(i-1, i, s);
            }
        }

        return this.ans;
    }
}
