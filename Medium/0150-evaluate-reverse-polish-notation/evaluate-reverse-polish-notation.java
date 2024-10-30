class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        
        for(String token: tokens) {
            switch (token) {
                case "+":
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case "-":
                    Integer numM1 = numbers.pop();
                    Integer numM2 = numbers.pop();
                    numbers.push(numM2 - numM1);
                    break;
                case "*":
                    numbers.push(numbers.pop() * numbers.pop());
                    break;
                case "/":
                    Integer numD1 = numbers.pop();
                    Integer numD2 = numbers.pop();
                    numbers.push(numD2 / numD1);
                    break;
                default:
                    numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }
}