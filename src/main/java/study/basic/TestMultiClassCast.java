package study.basic;

import study.model.Father;
import study.model.GrandPa;
import study.model.Son;

/**
 * Created by EricWang on 2019/7/11 8:24 PM.
 */
public class TestMultiClassCast {


    public static void main(String[] args) {

        GrandPa hehe = new Son();

       Father xixi =  (Father)hehe;
    }
}
