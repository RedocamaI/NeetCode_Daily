class Solution {
    protected List<Integer> combo = new ArrayList<>();
    protected List<List<Integer>> combos = new ArrayList<>();

    protected void printList() {
        for(int i=0;i<this.combo.size();i++) {
            System.out.println(this.combo.get(i));
        }
    }

    protected void getUniqueCombos(int ind, int target, int[] candi) {
        if(target == 0) {
            this.combos.add(new ArrayList<>(combo));
            return;
        }
        if(ind >= candi.length) {
            return;
        }

        // take:
        if(candi[ind] <= target) {
            this.combo.add(candi[ind]);
            getUniqueCombos(ind+1, target-candi[ind], candi);

            // backtracking:
            this.combo.remove(combo.size()-1);
        }else {
            return;
        }

        // not take:
        int i = ind+1;
        for(;i<candi.length;i++) {
            if(candi[i] != candi[ind]) {
                break;
            }
        }

        getUniqueCombos(i, target, candi);
    }

    public List<List<Integer>> combinationSum2(int[] candi, int target) {
        Arrays.sort(candi);
        int n = candi.length;
        
        getUniqueCombos(0, target, candi);

        return this.combos;
    }
}
