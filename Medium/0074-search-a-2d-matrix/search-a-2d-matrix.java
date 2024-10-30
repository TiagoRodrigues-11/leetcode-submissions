class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix[0].length * matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2 ;

            int rowIndex = mid / (matrix[0].length);
            int colIndex = mid % (matrix[0].length);

            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }

            if (matrix[rowIndex][colIndex] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}