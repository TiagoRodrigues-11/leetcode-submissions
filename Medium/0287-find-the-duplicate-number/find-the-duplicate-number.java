class Solution {
    public int findDuplicate(int[] nums) {
        // Constant extra space -> Floyd rabbit and hare algorythm

        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            if (slow == slow2) {
                return slow2;
            }
            slow = nums[slow];
            slow2 = nums[slow2];
        }

    }
}