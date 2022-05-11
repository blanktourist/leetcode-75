package main.problems.matrix;

import main.models.Directions;
import main.utils.GridUtils;

public class WordSearch {
    
    public static boolean doesWordExistInBoard(String[][] board, String word) {
        for (int i = 0; i < board. length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dp(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dp(String[][] board, String word, int index, int i, int j) {
        if (index >= word.length()) {
            return true;
        }

        if (!GridUtils.isInBounds(board, i, j) || !(board[i][j].equals(String.valueOf(word.charAt(index))))) {
            return false;
        }

        String boardVal = board[i][j];
        board[i][j] = ".";

        boolean ans = false;
        for (int[] direction : Directions.DIRECTIONS_ADJACENT_4) {
            int x = i + direction[0];
            int y = j + direction[1];

            ans = dp(board, word, index +1,  x, y);
            if (ans == true) {
                break;
            }
        }

        board[i][j] = boardVal;
        return ans;
    }

    public static void main(String[] args) {
        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(doesWordExistInBoard(board, word1));
        System.out.println(doesWordExistInBoard(board, word2));
        System.out.println(doesWordExistInBoard(board, word3));
    }
}
