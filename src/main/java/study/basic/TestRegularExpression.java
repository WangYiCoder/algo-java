package study.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EricWang on 2019/2/14 9:28 AM.
 */
public class TestRegularExpression {

    public static Pattern PATTERN_SCALING = Pattern.compile("_[0-9]+x[0-9]+");

    public static void main(String[] args) {

        String name1 = "aabb_123x45jdfhjdhf";

        String name2 = "aabbksdjfk123";

        String name3 = "aabb_123x45jdfhjdhfaabb_123x45jdfhjdhf";


        Matcher matcher1 = PATTERN_SCALING.matcher(name1);
        if (matcher1.find()){
            System.out.println("name1>>>>>>>>"+matcher1.group());
        }

        Matcher matcher2 = PATTERN_SCALING.matcher(name2);
        if (matcher2.find()){
            System.out.println("name2>>>>>>>>"+matcher2.group());
        }

        Matcher matcher3 = PATTERN_SCALING.matcher(name3);
        if (matcher3.find()){
            System.out.println("name3>>>>>>>>"+matcher3.group());
        }

        String name4 = "/lazada-review/797b0e2f5f4f437190d4a794c464121e_ee6489688c03434696fd39543c48ce10.jpg_79x79.jpg_webp";

        String newName = name4.substring(0, name4.indexOf("jpg") - 1);

        System.out.println(newName);

    }
}
