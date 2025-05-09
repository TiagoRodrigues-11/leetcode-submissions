class Solution {
    
    private Integer currentValue = 0;
    
    public int[][] specialGrid(int n) {
        if (n == 0) {
            return new int[1][1];
        }
        
        int size = (int)Math.pow(2, n);
        
        int[][] grid = new int[size][size];
        this.currentValue = 0;
        fillGrid(0, size-1, 0, size-1, grid);
        return grid;
    }
    
    public void fillGrid(int top, int bottom, int left, int right, int[][] grid) {

        if (right-left == 1 && bottom-top == 1) {
            grid[top][right] = currentValue++;
            grid[bottom][right] = currentValue++;
            grid[bottom][left] = currentValue++;
            grid[top][left] = currentValue++;
            return;
        }
        
        // Top-right
        fillGrid(top, (bottom+top)/2, (left+right)/2+1, right, grid);
        // Bottom-right
        fillGrid((bottom+top)/2+1, bottom, (left+right)/2+1, right, grid);
        // Bottom-left
        fillGrid((bottom+top)/2+1, bottom, left, (left+right)/2, grid);
        // Top-left
        fillGrid(top, (bottom+top)/2, left, (left+right)/2, grid);
    }
}