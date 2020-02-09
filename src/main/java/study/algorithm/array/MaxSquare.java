package study.algorithm.array;

/**
 * Created by EricWang on 2020/2/9 5:12 PM.
 * leetcode link: https://leetcode.com/problems/maximal-square/
 */
public class MaxSquare {

    public int maximalSquare(char[][] matrix) {
        int max = 0;

        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++){

                if (matrix[i][j] != '1'){
                    continue;
                }

                int temp = 1;

                out: while (true){

                    if (i+temp > matrix.length - 1 || j+temp > matrix[i].length - 1 ){
                        break;
                    }

                    for (int m = i; m < i+temp; m++){

                        if (matrix[m][j+temp] != '1'){
                            break out;
                        }
                    }

                    for (int n = j; n < j+temp; n++){
                        if (matrix[i+temp][n] != '1'){
                            break out;
                        }
                    }

                    if (matrix[i+temp][j+temp] != '1'){
                        break;
                    }
                    temp++;
                }

                if (temp > max){
                    max = temp;
                }


            }

        }

        return max * max;
    }

}
