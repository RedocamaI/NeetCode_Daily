class Solution {
    List<String> combos;
    StringBuffer combo;

    private void generateCombos(int ind, int cntOpen, int cntClose, int n) {
        if(ind == 2*n) {
            combos.add(this.combo.toString());
            return;
        }

        // take open:
        if(cntOpen < n) {
            combo.append("(");
            generateCombos(ind+1, cntOpen+1, cntClose, n);
            combo.deleteCharAt(combo.length()-1);
        }

        if(cntOpen > cntClose) {
            combo.append(")");
            generateCombos(ind+1, cntOpen, cntClose+1, n);
            combo.deleteCharAt(combo.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.combos = new ArrayList<>();
        this.combo = new StringBuffer("(");

        generateCombos(1, 1, 0, n);

        return this.combos;
    }
}
