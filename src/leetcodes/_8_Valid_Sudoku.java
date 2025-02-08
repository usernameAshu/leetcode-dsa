package leetcodes;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
 * to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition. Each column must contain the digits 1-9
 * without repetition. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 */

public class _8_Valid_Sudoku {

  /**
   * Approach:
   * Create an array of Set<Character> for rows, columns and boxes of size N
   * Initialize the arrays
   * So, we are basically adding letters to each array and checking whether the same letter was added before
   * The concept is same for rows and columns
   * For box, there is a special trick
   * Since we need to box elements of 3x3 boxes, below formulae boxes all 3x3 elements into each array
   * boxIdx = (row/3)*3 + (col/3)
   * this gives you the location of the Set<Character> where each box elements are present.
   * Run the similar check for box.
   * If the entire matrix is traversed without any duplicates, the function returns true.
   * @param args
   */
  public static void main(String[] args) {
    char[][] board =
        {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    System.out.println(isValidSudoku(board));
  }

  public static boolean isValidSudoku(char[][] board) {
    int N = board.length;

    Set<Character>[] row = new HashSet[N];
    Set<Character>[] col = new HashSet[N];
    Set<Character>[] box = new HashSet[N];

    //initialize the array
    for (int index = 0; index < N; index++) {
      row[index] = new HashSet<>();
      col[index] = new HashSet<>();
      box[index] = new HashSet<>();
    }

    //check for valid sudoku
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        char val = board[r][c];
        if (val == '.') {
          continue;
        }

        //row check
        if (row[r].contains(val)) {
          return false;
        }
        row[r].add(val);

        //column check
        if (col[c].contains(val)) {
          return false;
        }
        col[c].add(val);

        //box check
        int boxIdx = (r / 3) * 3 + (c / 3);
        if (box[boxIdx].contains(val)) {
          return false;
        }
        box[boxIdx].add(val);
      }
    }
    return true;
  }
}
