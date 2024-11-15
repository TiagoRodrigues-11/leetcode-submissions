class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        int pointer = 0;

        while(pointer < intervals.length) {
            int startInterval = intervals[pointer][0];
            int endInterval = intervals[pointer][1];

            while (pointer < intervals.length && intervals[pointer][0] <= endInterval) {
                if (intervals[pointer][1] >= endInterval) {
                    endInterval = intervals[pointer][1];
                }

                pointer++;
            }

            res.add(new int[]{startInterval, endInterval});
        }

        
        return res.toArray(new int[res.size()][]);

    }
}