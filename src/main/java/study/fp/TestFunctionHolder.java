package study.fp;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by EricWang on 2019/7/31 8:10 PM.
 */
public class TestFunctionHolder {

    public static void main(String[] args) {
        FunctionHolder functionHolder = FunctionHolder.addNumber();

        List<UnaryOperator<String>> actions = functionHolder.actions;

        for (UnaryOperator<String> action : actions){
            Class<? extends UnaryOperator> aClass = action.getClass();
            Method[] methods = aClass.getMethods();
            for (Method method : methods){
                System.out.println(method.getName());
            }


            System.out.println("*******************");
        }
    }
}
