class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> duplicatedNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (duplicatedNumbers.containsKey(nums[i])) {
                if (i - duplicatedNumbers.get(nums[i]) <= k) {
                    return true;
                }
            }

            duplicatedNumbers.put(nums[i], i);
        }

        return false;
    }
}