package study.algorithm.stack;

import java.util.*;

public class BalancedBrackets {

    static String isBalanced(String s) {

        char[] chars = s.toCharArray();

        Set<String> openBrackets = new HashSet<>(3);
        Set<String> closeBrackets = new HashSet<>(3);

        openBrackets.add("(");
        openBrackets.add("{");
        openBrackets.add("[");

        closeBrackets.add(")");
        closeBrackets.add("}");
        closeBrackets.add("]");


        Map<String,String> bracketsMapping = new HashMap<>();
        bracketsMapping.put(")","(");
        bracketsMapping.put("]","[");
        bracketsMapping.put("}","{");

        Stack<String> bracketsStack = new Stack<>();

        for (char c : chars){
            String bracket = String.valueOf(c);
            if (openBrackets.contains(bracket)){
                bracketsStack.push(bracket);
                continue;
            }

            try {
                String lastOneInStack = bracketsStack.pop();

                if (!lastOneInStack.equals(bracketsMapping.get(bracket))){
                    return "NO";
                }

            } catch (EmptyStackException e) {
                return "NO";
            }

        }

        if (bracketsStack.isEmpty()){
            return "YES";
        }

        return "NO";
    }
}
