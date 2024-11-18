class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if ("([{".indexOf(c) >= 0 ) {
                stack.push(c);
            } else {
                if (stack.empty()) return false;

                switch (c) {
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break; 
                }
            }
        }



        if (stack.empty()) {
            return true;
        }

        return false;
    }
}