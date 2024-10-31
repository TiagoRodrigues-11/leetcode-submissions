class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int lengthLongestSubstring = 0;

        for (int right = 0; right < s.length(); right++) {
            Character charRight = s.charAt(right);

            while (charMap.get(charRight) != null && charMap.get(charRight) > 0){
                charMap.put(s.charAt(left), charMap.get(s.charAt(left))-1);
                left++;
            }

            if (charMap.get(charRight) == null) {
                charMap.put(charRight, 0);
            }

            charMap.put(charRight, charMap.get(charRight)+1);
            lengthLongestSubstring = Math.max(
                lengthLongestSubstring, 
                right-left+1
            );
        }

        return lengthLongestSubstring;
    }
}