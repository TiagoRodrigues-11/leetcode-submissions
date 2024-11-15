class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRangesList = new ArrayList<>();

        int slow = 0, fast = 0;

        while(fast < nums.length) {
            String range = new String();
            range += nums[slow];

            while (fast < nums.length-1 && nums[fast+1] == nums[fast] + 1) {
                fast++;
            }

            if (slow != fast) {
                range += "->";
                range += nums[fast];
            }

            fast++;
            slow = fast;

            summaryRangesList.add(range);
        }

        return summaryRangesList;
    }
}