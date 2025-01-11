class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tempX = x;
        int palindrome = 0;
        
        while (tempX > 0) {
            int value = tempX % 10;
            palindrome = value + palindrome * 10;
            tempX = (int)(tempX / 10);
        }

        return palindrome == x;
    }
}