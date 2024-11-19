class Solution {
    public int lengthOfLastWord(String s) {
        String[] listOfString = s.split(" ");
        return listOfString[listOfString.length-1].length();
    }
}