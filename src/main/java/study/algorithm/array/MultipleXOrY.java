package study.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class MultipleXOrY {
    public static void main(String[] args) {

    }

    public static List<Integer> multiple(int x, int y, int z, int n) {
        // Write your code here

        List<Integer> result = new ArrayList<Integer>();

        if (z != 0) {
            if (x % z == 0 && y % z == 0) {
                return result;
            }
        }


        for (int i = 1; i <= n; i++) {

            boolean valid = checkIfValid(x, y, z, i);
            if (valid) {
                result.add(i);
            }

        }


        return result;

    }

    private static boolean checkIfValid(int x, int y, int z, int i) {

        if (z != 0) {
            if (i % z == 0) {
                return false;
            }
        }

        if (x != 0) {
            if (i % x == 0) {
                return true;
            }
        }


        if (y != 0) {
            if (i % y == 0) {
                return true;
            }
        }


        return false;
    }
}
