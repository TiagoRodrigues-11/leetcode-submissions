class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countNums = new HashMap<>();

        for(int num: nums) {
            if (!countNums.containsKey(num)) {
                countNums.put(num, 0);
            }

            countNums.put(num, countNums.get(num)+1);
        }
        
        int n = nums.length;
        for (int key: countNums.keySet()) {
            if (countNums.get(key) > Math.floor(n/2.0)) {
                return key;
            }
        }

        return -1;
        
    }
}