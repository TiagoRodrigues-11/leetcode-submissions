class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;

        int left = 0, right = 0;
        double sum = 0;

        for(; right < k; right++) {
            sum += nums[right];
        }

        maxAverage = Math.max(maxAverage, sum/k);

        while (right < nums.length) {
            sum = sum - nums[left] + nums[right];
            maxAverage = Math.max(maxAverage, sum/k);

            left++; right++;
        }

        return maxAverage;
    }
}