package study.basic;


import study.model.Father;
import study.model.GrandPa;

/**
 * Created by EricWang on 2019/11/24 10:10 AM.
 */
public class TestExtend {

    public static void main(String[] args) {
        Father f = new Father();
        System.out.println(f instanceof GrandPa);
    }
}
