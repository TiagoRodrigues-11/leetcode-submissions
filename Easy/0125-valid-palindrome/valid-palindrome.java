class Solution {
    public boolean isPalindrome(String s) {
        int j = s.length()-1;
        int i = 0;

        while(i <= j) {

            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++; continue;
            } 
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--; continue;
            } 

            Character ci = Character.toLowerCase(s.charAt(i));
            Character cj = Character.toLowerCase(s.charAt(j));
            
            if (!ci.equals(cj)) {
                return false;
            }

            i++;j--;
        }

        return true;
    }
}