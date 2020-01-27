package study.basic;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by EricWang on 2019/11/20 4:26 PM.
 */
public class TestTreeMap {

    public static void main(String[] args) {

        Map<Integer,String> numberTree = new TreeMap<>();

        numberTree.put(1,"a");
        numberTree.put(3,"a");
        numberTree.put(9,"a");
        numberTree.put(6,"a");
        numberTree.put(4,"a");

        for (Integer key: numberTree.keySet()){
            System.out.println(key);
        }
    }
}
