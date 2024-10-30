class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> setNums = new HashSet<>();

        for (int num: nums) {
            setNums.add(num);
        }

        int longSequence = 0;

        for(int num: nums) {

            // First number of the sequence
            if(setNums.contains(num-1)) {
                continue;
            }

            int sequence = 0;
            // Check if contains the next number
            while(setNums.contains(num + sequence)) {
                sequence++;
            }

            // Check if is the longest sequence
            if (sequence > longSequence) {
                longSequence = sequence;
            }
        }

        return longSequence;
    }
}