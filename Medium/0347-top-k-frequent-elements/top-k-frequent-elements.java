class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.replace(num, map.get(num)+1);
        }

        List<Map.Entry<Integer, Integer>> mapSorted = new ArrayList<>(map.entrySet());
        mapSorted.sort(Map.Entry.comparingByValue());
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = mapSorted.get(mapSorted.size()-i-1).getKey();
        }

        return res;
    }
}