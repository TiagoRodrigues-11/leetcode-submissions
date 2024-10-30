class Solution {

    public boolean checkAdd(HashMap<Integer, List<Character>> map, char c, int index) {

        if (!map.containsKey(index)) {
            map.put(index, new ArrayList<Character>());
        }

        List<Character> list = map.get(index);
        if (list.contains(c)){
            return false;
        }

        list.add(c);
        map.put(index, list);

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<Character>> rows = new HashMap<>();
        HashMap<Integer, List<Character>> cols = new HashMap<>();
        HashMap<Integer, List<Character>> sqrs = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                
                if (c == '.') {
                    continue;
                }

                // Check rows
            
                if (!checkAdd(rows, c, i)) {
                    return false;
                }

                // Check cols

                if (!checkAdd(cols, c, j)) {
                    return false;
                }

                // Check squares
                Integer sqrIndex = (i / 3) * 3 + (j / 3);

                if (!checkAdd(sqrs, c, sqrIndex)) {
                    return false;
                }

            }
        }
        return true;
    }
}