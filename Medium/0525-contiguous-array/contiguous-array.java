class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSums = new HashMap<>();

        int sum = 0;
        int maxSubarrayLen = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum--;
            }
            else{sum++;}

            if (sum == 0) {
                maxSubarrayLen = i+1;
            } else if (prefixSums.containsKey(sum)) {
                maxSubarrayLen = Math.max(maxSubarrayLen, i - prefixSums.get(sum));
            } else {
                prefixSums.put(sum, i);
            }
        }

        return maxSubarrayLen;
    }
}