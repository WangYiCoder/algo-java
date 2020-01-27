package study.basic;

/**
 * Created by EricWang on 2019/1/7 12:54 PM.
 */
public class TestAssignNullToPremitiveType {
    public static void main(String[] args) {
        Long time = null;

        int a = 1;

        if (a > 2) {
            time = 1L;
        }

        long realTime = time;

        System.out.println(realTime);
    }
}
