class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m)
            return false;
        
        HashMap<String, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        for(char c:s1.toCharArray()) {
            freq[c-97]++;
        }

        StringBuffer key = new StringBuffer("");
        for(int i=0;i<26;i++) {
            key.append(String.valueOf(freq[i]));
        }

        System.out.println("actual key: " + key);
        map.put(key.toString(), 1);
        key = new StringBuffer("");
        freq = new int[26];
        for(int i=0;i<n;i++) {
            freq[s2.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++) {
            key.append(String.valueOf(freq[i]));
        }
        if(map.containsKey(key.toString()))
            return true;
        
        System.out.println("key(0): " + key);
        for(int i=1;i<m-n+1;i++) {
            freq[s2.charAt(i-1)-97]--;
            freq[s2.charAt(i+n-1)-97]++;

            key = new StringBuffer("");
            for(int j=0;j<26;j++) {
                key.append(String.valueOf(freq[j]));
            }

            System.out.println("key(" + i + "): " + key);
            if(map.containsKey(key.toString()))
                return true;
        }

        if(map.containsKey(key))
            return true;

        return false;
    }
}
