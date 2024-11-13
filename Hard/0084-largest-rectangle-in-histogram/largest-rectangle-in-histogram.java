class Solution {
    public List<Integer> newPair(Integer index, Integer height) {
        List<Integer> pair = new ArrayList<>();
        pair.add(index);
        pair.add(height);
        return pair;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int index = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();

                int area = pair[1] * (i - pair[0]);
                maxArea = Math.max(maxArea, area);

                index = pair[0];
            }

            stack.push(new int[]{index, heights[i]});
        }


        for (int[] pair: stack) {
            maxArea = Math.max(maxArea, pair[1] * (heights.length - pair[0]));
        }

        return maxArea;
    }
}