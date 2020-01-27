package study.algorithm.backtracking;

/**
 * Created by EricWang on 2019/12/14 10:05 AM.
 */
public class EightQueens {

    private static int[] results = new int[8];
    private static int totalSolutions = 0;

    public static void main(String[] args) {
        for (int i = 0; i < results.length;i ++){
            results[i] = -1;
        }

        solveEightQueens(0);

        System.out.println("totalSolutions number = " + totalSolutions);
    }

    public static void solveEightQueens(int row){

        for (int column = 0; column < results.length; column ++){

            if (isOk(row,column)){
                results[row] = column;
                if (row == 7){
                    printResult();
                    continue;
                }
                solveEightQueens(row+1);
            }
        }

    }

    private static void printResult() {
        totalSolutions++;
        System.out.println("found one solution and start to print:===================");
        for(int i = 0; i < results.length; i ++){
            for (int j = 0; j < results.length; j ++){
                if (results[i] == j){
                    System.out.print("Q ");
                }else {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }

        System.out.println("one solution print finish:=============================");
    }

    private static boolean isOk(int row, int column) {

        int upperLeft = column - 1;
        int upperRight = column + 1;

        for (int i = row -1; i >= 0; i--){
            if (results[i] == column){
                return false;
            }

            if (upperLeft >= 0){
                if (results[i] == upperLeft){
                    return false;
                }
            }

            if (upperRight <= 7){
                if (results[i] == upperRight){
                    return false;
                }
            }
            upperLeft--;
            upperRight++;
        }

        return true;
    }
}
