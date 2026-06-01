class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = 0;
        char[] charsS = s.toLowerCase().toCharArray();
        int l = charsS.length;
        j = l-1;

        while(i <= j) {
            if(!Character.isLetterOrDigit(charsS[i])) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(charsS[j])) {
                j--;
                continue;
            }
            
            if(charsS[i++] != charsS[j--])
                return false;
        }

        return true;
    }
}
