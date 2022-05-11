package main.problems.tree;

import java.util.ArrayList;
import java.util.List;

import main.models.TrieNode;

public class WordSearchII {
    
    static char[][] board = null;
    static ArrayList<String> result = new ArrayList<String>();
    
    public static List<String> findWords(char[][] board, String[] words) {
        // construct trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.toString = word;
        }

        WordSearchII.board = board;
        // backtracking starting for each cell in the board
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i,j,root);
                }
            }
        }

        return WordSearchII.result;
    }

    private static void backtracking(int row, int col, TrieNode parent) {
        Character letter = WordSearchII.board[row][col];
        TrieNode currNode = parent.children.get(letter);
    
        // check if there is any match
        if (currNode.toString != null) {
            WordSearchII.result.add(currNode.toString);
          currNode.toString = null;
        }
    
        // mark the current letter before the EXPLORATION
        WordSearchII.board[row][col] = '#';
    
        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
          int newRow = row + rowOffset[i];
          int newCol = col + colOffset[i];
          if (newRow < 0 || newRow >= WordSearchII.board.length || newCol < 0
              || newCol >= WordSearchII.board[0].length) {
            continue;
          }
          if (currNode.children.containsKey(WordSearchII.board[newRow][newCol])) {
            backtracking(newRow, newCol, currNode);
          }
        }
    
        // End of EXPLORATION, restore the original letter in the board.
        WordSearchII.board[row][col] = letter;
    
        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
          parent.children.remove(letter);
        }
    }

    public static void main(String[] args) {
        char[][] board1 = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}, {'i','f','l','v'}};
        String[] words1 = {"oath","pea","eat","rain"};

        System.out.println(findWords(board1, words1));
    }
}
