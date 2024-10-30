class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> raises = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!raises.empty() && temperatures[i] > temperatures[raises.peek()]) {
                int index = raises.pop();
                answer[index] = i - index;
            }

            raises.push(i);
        }

        return answer;
    }
}