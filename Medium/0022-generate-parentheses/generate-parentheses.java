class Solution {

    private String generateStringFromStack(Stack<Character> stack) {
        return stack.stream().map(s -> s.toString()).collect(Collectors.joining(""));
    }

    public List<String> generateParenthesis(int n) {
        
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push('(');
            stack.push(')');
        }

        // ()()()
        List<String> res = new ArrayList<>();
        res.add(generateStringFromStack(stack));

        while(true) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('(', 0);
            map.put(')', 0);

            while(true) {
                Character c = stack.pop();  // "(" or ")" 
                map.put(c, map.get(c)+1);

                if(c == ')' && map.get('(') > 0) {
                    stack.push('(');
                    map.put('(', map.get('(')-1);

                    for(int i = map.get(')'); i > map.get('('); i--) {
                        stack.push(')');
                        map.put(')', map.get(')')-1);
                    }

                    int max = map.get('(');
                    for(int i = 0; i < max; i++) {
                        stack.push('(');
                        map.put('(', map.get('(')-1);
                        stack.push(')');
                        map.put(')', map.get(')')-1);
                    }

                    res.add(generateStringFromStack(stack));

                }

                if(stack.empty()) {
                    return res;
                }
            }
        }

    }
}