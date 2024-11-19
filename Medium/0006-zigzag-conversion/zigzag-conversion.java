class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<List<Character>> resList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            resList.add(new ArrayList<>());
        }

        int indexS = 0;
        int indexList = 0;
        int add = 1;

        while(indexS < s.length()) {
            resList.get(indexList).add(s.charAt(indexS));

            if (add == 1 && indexList == numRows-1) {
                add = -1;
            } else if (add == -1 && indexList == 0) {
                add = 1;
            }

            indexList += add;
            indexS++;
        }



        String res = new String();

        for (List<Character> list: resList) {
            for(Character c: list) {
                res += c;
            }
        }
        return res;
    }
}