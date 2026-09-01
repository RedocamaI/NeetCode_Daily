class Solution {
    List<String> ans;

    private String fillChars(Character ch) {
        switch(ch) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "faaah!";
        }
    }

    private void generateCombos(int i, StringBuffer combo, List<String> combos) {
        if(i == combos.size()) {
            String comboStr = combo.toString();
            ans.add(comboStr);

            return;
        }


        String chars = combos.get(i);
        for(int j=0;j<chars.length();j++) {
            combo.append(chars.charAt(j));

            generateCombos(i+1, combo, combos);

            combo.deleteCharAt(combo.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        List<String> combos = new ArrayList<>();
        ans = new ArrayList<>();

        for(int i=0;i<digits.length();i++) {
            String chars = fillChars(digits.charAt(i));

            combos.add(chars);
        }

        StringBuffer combo = new StringBuffer("");

        generateCombos(0, combo, combos);

        return this.ans;
    }
}
