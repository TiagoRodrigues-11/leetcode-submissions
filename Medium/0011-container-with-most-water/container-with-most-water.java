class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int bestWater = -1;

        while (left < right) {
            int water = (right-left) * Math.min(height[left], height[right]);

            if (water > bestWater) {
                bestWater = water;
            }

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return bestWater;
    }
}