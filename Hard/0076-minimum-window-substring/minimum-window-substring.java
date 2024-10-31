class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int haveSum = 0;
        int needSum = 0;

        for(int indexT = 0; indexT < t.length(); indexT++) {
            Character c = t.charAt(indexT);
            if (!need.containsKey(c)){
                have.put(c, 0);
                need.put(c, 0);
            }
            needSum++;
            need.put(c, need.get(c)+1);
        }

        List<Integer> resList = new ArrayList<>();
        resList.add(-1);
        resList.add(-1);

        Integer resSize = Integer.MAX_VALUE;

        for(int left = 0, right = 0; right < s.length(); right++) {
            Character rightChar = s.charAt(right);

            if (have.containsKey(rightChar)) {
                have.put(rightChar, have.get(rightChar)+1);
                if (have.get(rightChar) <= need.get(rightChar)) {
                    haveSum++;
                }
            }

            while(haveSum == needSum) {

                if (resSize > right - left + 1) {
                    resSize = right - left + 1;
                    resList.set(0, left);
                    resList.set(1, right);
                }

                Character leftChar = s.charAt(left);
                
                if(have.containsKey(leftChar)) {
                    if (have.get(leftChar) <= need.get(leftChar)) {
                        haveSum--;
                    }
                    have.put(leftChar, have.get(leftChar)-1);
                }

                left++;
            }
        }

        if (resList.get(0).equals(-1)) {
            return "";
        }
        return s.substring(resList.get(0), resList.get(1)+1);
    }
}