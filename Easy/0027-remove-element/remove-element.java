class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int left = 0; 
        int right = 0;

        while(right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                k++;
                left++;
            }

            right++;
        }

        return k;
    }
}