class Solution {
    StringBuffer substr;
    List<String> sub;
    List<List<String>> ans;

    private boolean isPal(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    private void getPals(int ind, String s) {
        if(ind == s.length()) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int i=ind;i<s.length();i++) {
            if(!isPal(s, ind, i))
                continue;
            
            sub.add(s.substring(ind, i+1));

            getPals(i+1, s);

            // backtrack:
            sub.remove(sub.size()-1);
        }
    }

    public List<List<String>> partition(String s) {
        this.sub = new ArrayList<>();
        this.ans = new ArrayList<>();
        getPals(0, s);

        return this.ans;
    }
}
