class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<String> sList = new ArrayList<String>(Arrays.asList(s.split("")));
        List<String> tList = new ArrayList<String>(Arrays.asList(t.split("")));

        Collections.sort(sList);
        Collections.sort(tList);

        for (int i = 0; i < sList.size(); i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }
}