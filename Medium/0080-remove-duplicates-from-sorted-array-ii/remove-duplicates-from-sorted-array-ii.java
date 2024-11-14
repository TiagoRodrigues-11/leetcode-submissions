class Solution {
    public int removeDuplicates(int[] nums) {
        int set = 0;
        int slow = 0;
        int fast = 0;

        while(fast < nums.length) {

            while(fast < nums.length && nums[slow] == nums[fast]) {
                if (fast - slow < 2) {
                    nums[set] = nums[slow];
                    set++;
                }
                fast++;
            }

            slow = fast;
        }

        return set;
    }
}