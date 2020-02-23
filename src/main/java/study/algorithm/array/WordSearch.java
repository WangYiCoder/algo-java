package study.algorithm.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by EricWang on 2020/2/8 6:47 PM.
 */
public class WordSearch {

    private int pointer = 0;
    private Set<Point> usedPoints = new HashSet<>();

    public boolean exist(char[][] board, String word) {

        if (word.length() == 0 || board.length == 0){
            return false;
        }

        char[] targets = word.toCharArray();
        char head = targets[0];

        for (int i = 0; i < board.length; i++){

            for (int j = 0; j<board[i].length; j++){

                if (board[i][j] == head){
                  pointer = 0;
                  usedPoints.clear();
                  explore(i,j,targets,board);

                  if (pointer == targets.length -1){
                      return true;
                  }
                }
            }


        }


        return false;
    }

    private void explore(int i, int j, char[] targets, char[][] board) {

        Point point = new Point(i, j);
        //check if already used.
        if (usedPoints.contains(point)){
            pointer--;
            return;
        }

        //check if match.
        if (board[i][j] != targets[pointer]){
            pointer--;
            return;
        }

        usedPoints.add(point);

        if (pointer == targets.length - 1){
            return;
        }

        //explore up:
        if (i-1 >= 0){
            pointer++;
            explore(i-1,j,targets,board);
            if (pointer == targets.length - 1){
                return;
            }
        }

        //explore down
        if (i+1 < board.length){
            pointer++;
            explore(i+1, j, targets,board);
            if (pointer == targets.length - 1){
                return;
            }
        }

        //explore left
        if (j-1 >= 0){
            pointer ++;
            explore(i,j-1, targets,board);
            if (pointer == targets.length - 1){
                return;
            }
        }

        //explore right
        if (j+1 < board[i].length){
            pointer++;
            explore(i,j+1, targets, board);
            if (pointer == targets.length - 1){
                return;
            }
        }

        pointer--;
        usedPoints.remove(point);

    }

    class Point {

        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = new char[][]{{'a'}};
        String word = "ab";
        //String word = "ABCCED";

        //char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //String word = "AAB";

        WordSearch t = new WordSearch();
        System.out.println(t.exist(board,word));

        System.out.println(WordSearch.class.getName());
    }



}
