class Solution {
    public boolean containsT(HashMap<Character, Integer> map, String t) {
        HashMap<Character, Integer> newMap = new HashMap<>(map);

        for(Character ch: t.toCharArray()) {
            if(!newMap.containsKey(ch))
                return false;
            if(newMap.get(ch) == 1) {
                newMap.remove(ch);
            }else {
                newMap.put(ch, newMap.get(ch)-1);
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        
        int n = s.length();
        int m = t.length();
        int x = -1, y = -1, minLen = n;

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        for(int r=0;r<n;r++) {
            char chR = s.charAt(r);
            map.put(chR, map.containsKey(chR) ? map.get(chR)+1 : 1);
            while(r < n && (r-l+1) >= m && containsT(map, t)) {
                if((r-l+1) <= minLen) {
                    x = l;
                    y = r;
                    minLen = (r-l+1);
                }

                char chL = s.charAt(l);
                if(map.get(chL) == 1) {
                    map.remove(chL);
                }else {
                    map.put(chL, map.get(chL)-1);
                }

                l++;
            }
        }

        if(x == -1 || y == -1)
            return "";

        StringBuffer minString = new StringBuffer("");
        for(int i=x;i<=y;i++) {
            minString.append(s.charAt(i));
        }

        return minString.toString();
    }
}
