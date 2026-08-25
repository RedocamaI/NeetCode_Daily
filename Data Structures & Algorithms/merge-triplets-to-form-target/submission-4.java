class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        if(n == 1) {
            return triplets[0][0] == target[0] &&
                triplets[0][1] == target[1] &&
                triplets[0][2] == target[2];
        }
        
        int[] indexes = new int[n];
        List<int[]> maps = new ArrayList<>();

        for(int x=0;x<3;x++) {
            int[] map = new int[101];
            for(int i=0;i<n;i++) {
                map[triplets[i][x]]++;
            }

            maps.add(map);
        }

        if(maps.get(0)[target[0]] == 0 ||
            maps.get(1)[target[1]] == 0 ||
            maps.get(2)[target[2]] == 0)
                return false;

        int a = target[0];
        List<Integer> aList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(a < triplets[i][0])
                indexes[i] = -1;
            if(a == triplets[i][0])
                aList.add(i);
        }

        int b = target[1];
        List<Integer> bList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(indexes[i] == -1)
                continue;
            if(b < triplets[i][1])
                indexes[i] = -1;
            if(b == triplets[i][1])
                bList.add(i);
        }

        int c = target[2];
        List<Integer> cList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(indexes[i] == -1)
                continue;
            if(c < triplets[i][2])
                indexes[i] = -1;
            if(c == triplets[i][2])
                cList.add(i);
        }

        int aValid = 0;
        for(int i=0;i<aList.size();i++) {
            if(indexes[aList.get(i)] != -1)
                aValid++;
        }
        if(aValid == 0)
            return false;
        
        int bValid = 0;
        for(int i=0;i<bList.size();i++) {
            if(indexes[bList.get(i)] != -1)
                bValid++;
        }
        if(bValid == 0)
            return false;

        int cValid = 0;
        for(int i=0;i<cList.size();i++) {
            if(indexes[cList.get(i)] != -1)
                cValid++;
        }
        if(cValid == 0)
            return false;
        
        return true;
    }
}
