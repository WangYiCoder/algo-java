package study.algorithm.array;

/**
 * Created by EricWang on 2020/4/5 10:12 AM.
 */
public class MaxAdjacency {

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 0,1, 1, 1};

        MaxAdjacency t = new MaxAdjacency();
        System.out.println(t.solution(A));
    }

    int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.min(r, count);
        }
        return result + r;
    }

    //todo need to change at most 3 lines in the below solution to make it correct
    //can't remove or add line
    /*int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.min(r, count);
        }
        return result + r;
    }*/
}
