class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Creating the set for rows, cols and boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize the sets for all the cells
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Iterate through all the cells
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int boxIndex = (row / 3) * 3 + (col / 3);
                char c = board[row][col];
                if (c == '.') continue;

                if (!rows[row].add(c) || !cols[col].add(c) || !boxes[boxIndex].add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
