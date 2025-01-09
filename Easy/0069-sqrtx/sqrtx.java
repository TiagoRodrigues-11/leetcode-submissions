class Solution {
    public int mySqrt(int x) {
        long left = 1, right = x;
        long res = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long squaredMid = mid * mid;

            if (squaredMid == x) {
                return (int)mid;
            } else if (squaredMid > x) {
                right = mid-1;
            } else {
                res = mid;
                left = mid+1;
            }

        }

        return (int) res;
    }
}