class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return "";
        
        StringBuffer encoded = new StringBuffer("");

        // System.out.println("len s: ");

        for(String str : strs) {
            int len = str.length();

            // System.out.println(len);

            encoded.append(String.valueOf(len));
            encoded.append("l");
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<Integer> getMetaData(int ind, String s) {
        StringBuffer lString = new StringBuffer("");
        int i = ind;
        while(true) {
            if(s.charAt(ind) == 'l') {
                i = ind;
                break;
            }
            
            lString.append(s.charAt(ind));
            ind++;
        }

        int l = Integer.parseInt(lString.toString());
        
        return List.of(i+1, l);
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();

        // System.out.println("l :");

        for(int i=0;i<str.length();i++) {
            StringBuffer decodedWord = new StringBuffer("");
            List<Integer> decodedMetaData = getMetaData(i, str);
            int l = decodedMetaData.get(1);
            int j = decodedMetaData.get(0);
            int k = j;

            // System.out.println(l);

            while(j < k+l && j < str.length()) {
                decodedWord.append(str.charAt(j));
                j++;
            }

            i = j-1;
            decoded.add(decodedWord.toString());
        }

        return decoded;
    }
}
