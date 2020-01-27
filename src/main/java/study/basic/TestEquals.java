package study.basic;

/**
 * Created by EricWang on 2019/3/19 2:45 PM.
 */
public class TestEquals {

    public static void main(String[] args) {

        TestEquals t1 = new TestEquals();
        TestEquals t2 = new TestEquals();

        System.out.println(t1 == t2);
        System.out.println( null == null);
    }

    @Override
    public int hashCode() {
        return 123;
    }
}
