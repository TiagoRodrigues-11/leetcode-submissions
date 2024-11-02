class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        Integer min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.println("");
            System.out.println(left + " " + mid + " " + right);
            System.out.println(nums[left] + " " + nums[mid] + " " + nums[right]);
 
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (min > nums[mid]) {
                min = nums[mid];
            }
        }

        return min;
    }
}