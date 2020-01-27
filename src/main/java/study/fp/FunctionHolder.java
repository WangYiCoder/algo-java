package study.fp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by EricWang on 2019/7/31 8:02 PM.
 */
public class FunctionHolder {

    public List<UnaryOperator<String>> actions = new ArrayList<>();

    public FunctionHolder(List<UnaryOperator<String>> actions) {
        this.actions = actions;
    }

    public static  FunctionHolder addNumber(){

        return new FunctionHolder(Lists.newArrayList(
                t -> printInput(t),
                t -> addNumberAsSuffix(t,2)
        ));
    }

    private static String addNumberAsSuffix(String t, int i) {
        System.out.println("addNumberAsSuffix:" + t + i);
        return t;
    }

    private static String printInput(String t) {

        System.out.println("printInput" + t);

        return t;
    }

}
