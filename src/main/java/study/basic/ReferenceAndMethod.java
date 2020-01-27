package study.basic;

/**
 * Created by EricWang on 2019/7/2 5:43 PM.
 */
public class ReferenceAndMethod {

    public static void main(String[] args) {

        BaseEntity b = new BaseEntity();
        b.setAttr("1111");

        setAge(b);


        System.out.println(b);

    }

    public static void setAge(BaseEntity b) {
        b.setAttr("2222");

        BaseEntity c = new BaseEntity();

        c.setAttr("3333");

        b = c;

    }


}


