class Solution {
    public void rotate(int[] nums, int k) {
        HashMap<Integer, Integer> countNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countNums.put(i, nums[i]);
        }

        for (int key: countNums.keySet()) {
            nums[(key+k)%nums.length] = countNums.get(key);
        }

    }
}