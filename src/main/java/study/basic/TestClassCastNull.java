package study.basic;

/**
 * Created by EricWang on 2019/5/7 3:51 PM.
 */
public class TestClassCastNull {

    public static void main(String[] args) {
        Object a = "hehe";
        a = null;
        String b = (String)a;

        System.out.println(b);
        System.out.println(Integer.MAX_VALUE);
    }
}
