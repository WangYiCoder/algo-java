package study.algorithm.simple;

/**
 * Created by EricWang on 2019/11/8 3:55 PM.
 */
public class JumpingOnClouds {

    public static void main(String[] args) {

    }

    static int jumpingOnClouds(int[] c) {

        int steps = 0;

        int currentPosition = 0;

        for (int i  = 0; ; ){

            if (currentPosition >= c.length -1){
                break;
            }

            if (i == c.length -2){
                steps += 1;
                break;
            }

            if (c[i+1] == 0 && c[i+2] == 1){
                currentPosition = i + 1;
                steps += 1;
                i = currentPosition;
                continue;
            }

            currentPosition = i + 2;
            steps += 1;
            i  = currentPosition;

        }

        return steps;
    }

}
