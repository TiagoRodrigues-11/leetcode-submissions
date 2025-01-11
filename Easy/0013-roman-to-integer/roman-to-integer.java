class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanDictionary = new HashMap<>();
        romanDictionary.put('I', 1);
        romanDictionary.put('V', 5);
        romanDictionary.put('X', 10);
        romanDictionary.put('L', 50);
        romanDictionary.put('C', 100);
        romanDictionary.put('D', 500);
        romanDictionary.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = romanDictionary.get(s.charAt(i));

            if (i < s.length()-1 && value < romanDictionary.get(s.charAt(i+1))) {
                res -= value;
                continue;
            }

            res += value;
        }

        return res;
    }
}