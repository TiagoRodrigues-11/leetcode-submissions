class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > 0) {
                break;
            }

            if (i != 0 && nums[i] == nums[i-1]){
                continue;
            }

            int start = i+1;
            int end = nums.length-1;

            while (start < end) {
                int sum = nums[start] + nums[end] + num;

                if (sum > 0) {
                    end--;
                }
                else if (sum < 0) {
                    start++;
                }
                else {
                    result.add(Arrays.asList(num, nums[start], nums[end]));
                    start++;
                    while (nums[start] == nums[start-1] && start < end) {
                        start++;
                    }
                }

                
            }

        }

        return result;
    }
}