class Solution {
    public boolean checkValidString(String s) {
        if(s.charAt(0) == ')')
            return false;
        
        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '*'){
                star.push(i);
                continue;
            }
            
            if(s.charAt(i) == '('){
                openStack.push(i);
            }
            else {
                if(openStack.isEmpty()) {
                    if(star.isEmpty())
                        return false;
                    
                    star.pop();
                }else   openStack.pop();
            }
        }

        if(openStack.isEmpty())
            return true;

        while(!openStack.isEmpty() && !star.isEmpty()) {
            if(openStack.peek() > star.peek())
                return false;
            
            openStack.pop();
            star.pop();
        }

        return openStack.isEmpty();
    }
}
