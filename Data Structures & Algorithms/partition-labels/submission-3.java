class Solution {
    private Map<Character, Integer> map;

    private boolean haveFoundPartition(int end, int start, String s) {
        for(int i=start;i<=end;i++) {
            if(this.map.get(s.charAt(i)) > end)
                return false;
        }

        return true;
    }

    public List<Integer> partitionLabels(String s) {
        this.map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0;
        int end = 0;
        int length = 0;

        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i)) >= i) {
                end = map.get(s.charAt(i));

                if(haveFoundPartition(end, start, s)) {
                    length = end - start + 1;
                    partitions.add(length);

                    i = end;

                    start = end+1;
                    end = end+1;
                }
            }
        }

        return partitions;
    }
}
