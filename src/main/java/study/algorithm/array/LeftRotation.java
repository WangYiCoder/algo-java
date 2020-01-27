package study.algorithm.array;

/**
 * Created by EricWang on 2019/11/8 6:27 PM.
 */
public class LeftRotation {

    public static void main(String[] args) {

    }

    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        if (n == d){
            return  a;
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++){
            if (i < d){
                b[n-d+i] = a[i];
                continue;
            }

            b[i -d] = a[i];
        }


        return b;
    }
}
