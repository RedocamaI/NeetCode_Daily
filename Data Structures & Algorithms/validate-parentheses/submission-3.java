class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(Character ch : s.toCharArray()) {
            if(ch == '(' || 
            ch == '{' ||
            ch == '[')
                st.push(ch);
            else {
                if(st.isEmpty())
                    return false;
                
                if(ch == ')' && st.peek() != '(' ||
                (ch == ']' && st.peek() != '[') ||
                (ch == '}' && st.peek() != '{'))
                    return false;
                st.pop();
            }
        }

        return st.isEmpty();
    }
}
