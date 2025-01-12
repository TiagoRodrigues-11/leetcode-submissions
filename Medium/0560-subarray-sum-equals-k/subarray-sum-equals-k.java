class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int count = 0;

        map.put(total, 1);

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];

            if (map.containsKey(total - k)) {
                count += map.get(total - k);
            }

            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return count;
    }
}