public class SudokuValidator {

    public boolean isValidSudoku(int[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }

        // Check each 3x3 subgrid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubgrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(int[][] board, int row) {
        boolean[] seen = new boolean[10]; // 0-9, used to check if a number has been seen
        for (int col = 0; col < 9; col++) {
            int num = board[row][col];
            if (num != 0 && seen[num]) {
                return false; // Duplicate found
            }
            seen[num] = true;
        }
        return true;
    }

    private boolean isValidColumn(int[][] board, int col) {
        boolean[] seen = new boolean[10]; // 0-9, used to check if a number has been seen
        for (int row = 0; row < 9; row++) {
            int num = board[row][col];
            if (num != 0 && seen[num]) {
                return false; // Duplicate found
            }
            seen[num] = true;
        }
        return true;
    }

    private boolean isValidSubgrid(int[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[10]; // 0-9, used to check if a number has been seen
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                int num = board[row][col];
                if (num != 0 && seen[num]) {
                    return false; // Duplicate found
                }
                seen[num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {0, 9, 0, 3, 8, 4, 0, 0, 0},
                {0, 0, 2, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 1},
                {5, 0, 0, 0, 0, 3, 2, 4, 0},
                {0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 5, 0, 9, 0},
                {0, 0, 0, 8, 0, 0, 0, 0, 0},
                {7, 0, 6, 5, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 4, 0, 0}
        };


        SudokuValidator validator = new SudokuValidator();
        boolean isValid = validator.isValidSudoku(sudokuBoard);
        if (isValid) {
            System.out.println("The Sudoku board is valid.");
        } else {
            System.out.println("The Sudoku board is invalid.");
        }
    }
}
