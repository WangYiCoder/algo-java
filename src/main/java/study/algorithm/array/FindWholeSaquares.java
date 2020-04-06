package study.algorithm.array;

/**
 * Created by EricWang on 2020/4/5 9:42 AM.
 */
public class FindWholeSaquares {

    public static void main(String[] args) {
        int A = 0;

        int B = 100;

        FindWholeSaquares t = new FindWholeSaquares();

        System.out.println(t.solution(A,B));
    }

    public int solution(int A, int B) {
        // write your code in Java SE 8
        int leftBound = A < 0 ? 0 : A;
        int rightBound = B < 0 ? 0 : B;
        if(leftBound == 0 && rightBound == 0){
            return 0;
        }

        //find first Q that Q square is greater than leftBound and less than rightBound

        int probe = leftBound;
        while(probe * probe >= leftBound && leftBound != 0 ){
            probe = probe/2;

        }

        while (probe * probe < leftBound){
            probe ++;
        }

        int count = 0;

        while ( probe * probe >= leftBound && probe * probe <= rightBound){
            count++;
            probe++;
        }

        return count;

    }
}
