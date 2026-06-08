class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> mp = new HashMap<>();
        int l = 0;
        int ans = 0;
        for(int r=0;r<n;r++) {
            Integer val = mp.get(s.charAt(r));
            int freq = (val != null) ? val : 0;
            mp.put(s.charAt(r), freq+1);
            
            while(mp.containsKey(s.charAt(r)) &&
            mp.get(s.charAt(r)) > 1 && l < n) {
                freq = mp.get(s.charAt(l));

                mp.put(s.charAt(l), freq-1);
                l++;
            }

            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}
