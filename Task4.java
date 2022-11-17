/* На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

import java.util.Arrays;


public class Task4 {
    public static void main(String[] args) {
        char[][] chessBoard = new char[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            Arrays.fill(chessBoard[i], '–');
        }
        eightQueen(chessBoard, 0);
    }

    private static boolean isSafePosition(char[][] board, int r, int c)
    {
        for (int i = 0; i < r; i++)
        {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++)
        {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void eightQueen(char[][] board, int r)
    {
        if (r == board.length)
        {
            for (char[] chars: board) {
                System.out.println(Arrays.toString(chars).replaceAll(",", ""));
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < board.length; i++)
        {
            if (isSafePosition(board, r, i))
            {
                board[r][i] = 'Q';
                eightQueen(board, r + 1);
                board[r][i] = '–';
            }
        }
    }
}

//    public static void main(String[] args) {
//        String chessBoard[][] = new String[8][8];
//        printArray(queenPath(emptyBoard(chessBoard)));
//    }
//
//    static String[][] emptyBoard(String[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                arr[i][j] = "-";
//            }
//        }
//        return arr;
//    }
//
//    static String[][] queenPath(String[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i][j].equals("-")) {
//                    arr[i][j] = "Q";
//                    for (int k = 0; k < arr.length; k++) {
//                        if (!arr[i][k].equals("Q")) {
//                            arr[i][k] = "X";
//                        }
//                    }
//                    for (int k = 0; k < arr.length; k++) {
//                        if (!arr[k][j].equals("Q")) {
//                            arr[k][j] = "X";
//                        }
//                    }
//                    int m = i;
//                    int n = j;
//                    while (m <= 7 && n <= 7) {
//                        if (arr[m][n].equals("-")) {
//                            arr[m][n] = "X";
//                        }
//                        m += 1;
//                        n += 1;
//                    }
//                    m = i;
//                    n = j;
//                    while (m <= 7 && n >= 0) {
//                        if (arr[m][n].equals("-")) {
//                            arr[m][n] = "X";
//                        }
//                        m += 1;
//                        n -= 1;
//                    }
//                }
//            }
//        }
//        return arr;
//    }
//
//    static void printArray(String[][] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.printf(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
