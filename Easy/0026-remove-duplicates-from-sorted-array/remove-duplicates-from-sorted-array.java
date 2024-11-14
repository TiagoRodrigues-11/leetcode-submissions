class Solution {
    public int removeDuplicates(int[] nums) {
        int set = 0;
        int slow = 0;
        int fast = 0;

        while(fast < nums.length) {
            nums[set] = nums[slow];
            set++;

            while(fast < nums.length && nums[slow] == nums[fast]) {
                fast++;
            }

            slow = fast;
        }

        return set;
    }
}