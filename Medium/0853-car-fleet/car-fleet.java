class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<List<Integer>> positionSpeed = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(position[i]);
            list.add(speed[i]);
            positionSpeed.add(list);
        }

        positionSpeed.sort(
            Comparator.comparingInt(tuple -> tuple.get(0))
        );
        positionSpeed = positionSpeed.reversed();

        Stack<Double> times = new Stack<>();        // Use Stack for keep tracking how many fleet there are

        for (List<Integer> car: positionSpeed) {
            Double targetPos = new Double(target);
            Double time = (targetPos - car.get(0)) / car.get(1);
            
            if (times.empty()) {
                times.push(time);
                continue;
            }
            
            if (times.peek() < time){
                times.push(time);
            }
        }

        return times.size();
    }
}