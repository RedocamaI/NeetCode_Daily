class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int maxFreq = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int r=0;r<n;r++) {
            Character key = s.charAt(r);
            map.put(key, map.getOrDefault(key, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(key));

            while(l < r && (r-l+1 - maxFreq) > k) {
                int freqAtL = map.getOrDefault(s.charAt(l), 0);
                if(freqAtL == 0)
                    map.remove(s.charAt(l));
                else
                    map.put(s.charAt(l), freqAtL-1);
                
                l++;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}
