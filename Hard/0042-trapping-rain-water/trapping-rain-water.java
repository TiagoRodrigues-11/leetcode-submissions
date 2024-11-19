class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];

        while(left < right) {

            if (height[left] < height[right]) {
                trappedWater += Math.max(0, Math.min(maxLeft, maxRight) - height[left]);
                left++;
            } else {
                trappedWater += Math.max(0, Math.min(maxLeft, maxRight) - height[right]);
                right--;
            }

            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);
        }

        return trappedWater;
    }
}