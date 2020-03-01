package study.basic;

/**
 * Created by EricWang on 2020/2/23 8:08 PM.
 */
public class TestPassReference {

    private int value;

    public TestPassReference(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {

        TestPassReference origin = new TestPassReference(1);

        changeReference(origin);

        System.out.println(origin.getValue() == 1);


    }


    public static void changeReference(TestPassReference origin){

        TestPassReference newObject = new TestPassReference(origin.getValue() + 1);
        origin = newObject;
    }
}
