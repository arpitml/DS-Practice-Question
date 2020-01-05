/**
* input : board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

 public boolean exist(char[][] board, String word) {

        row = board.length;
        col = board[0].length;
        boolean[][] visited;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited = new boolean[row][col];
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (search(word.substring(1), board, visited, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean search(String word, char[][] board, boolean[][] visited, int i, int j) {
        boolean exist = false;

        if (word.length() == 0) {
            exist = true;
        } else {
            // top
            if (i - 1 >= 0 && board[i - 1][j] == word.charAt(0) && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                if (search(word.substring(1), board, visited, i - 1, j))
                    return true;
                visited[i - 1][j] = false;
            }
            // left
            if (j - 1 >= 0 && board[i][j - 1] == word.charAt(0) && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                if (search(word.substring(1), board, visited, i, j - 1))
                    return true;
                visited[i][j - 1] = false;
            }
            // right
            if (j + 1 < col && board[i][j + 1] == word.charAt(0) && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                if (search(word.substring(1), board, visited, i, j + 1))
                    return true;
                visited[i][j + 1] = false;
            }
            // down
            if (i + 1 < row && board[i + 1][j] == word.charAt(0) && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                if (search(word.substring(1), board, visited, i + 1, j))
                    return true;
                visited[i + 1][j] = false;
            }
            // for digonal direction
            /*
             // top-left
            if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == word.charAt(0) && !visited[i - 1][j - 1]) {
                visited[i - 1][j - 1] = true;
                search(word.substring(1), board, visited, i - 1, j - 1);
                visited[i - 1][j - 1] = false;
            }
            // top-right
            if (i - 1 >= 0 && j + 1 < col && board[i - 1][j + 1] == word.charAt(0) && !visited[i - 1][j + 1]) {
                visited[i - 1][j + 1] = true;
                search(word.substring(1), board, visited, i - 1, j + 1);
                visited[i - 1][j + 1] = false;
            }
            // down-left
            if (i + 1 < row && j - 1 >= 0 && board[i + 1][j - 1] == word.charAt(0) && !visited[i + 1][j - 1]) {
                visited[i + 1][j - 1] = true;
                search(word.substring(1), board, visited, i + 1, j - 1);
                visited[i + 1][j - 1] = false;
            }
            // down-right
            if (i + 1 < row && j + 1 < col && board[i + 1][j + 1] == word.charAt(0) && !visited[i + 1][j + 1]) {
                visited[i + 1][j + 1] = true;
                search(word.substring(1), board, visited, i + 1, j + 1);
                visited[i + 1][j + 1] = false;
            }
          */
        }
        return exist;
    }
  } 
