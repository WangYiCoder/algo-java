package study.basic;

/**
 * Created by EricWang on 2020/2/6 9:15 PM.
 */
public class Constructor {

    static String str;
    public void Constructor(){
        System.out.println("iiii");
        str = "Hello world";
    }

    public static void main(String[] args) {
        Constructor c = new Constructor();
        System.out.println(str);

        int a = 2;
        int b = 4;
        a = a &b;
        b = a | b;
        a = a | b;
        System.out.println(a);
        System.out.println(b);
    }
}
