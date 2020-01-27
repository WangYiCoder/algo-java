package study.basic;


import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by EricWang on 2019/11/26 5:52 PM.
 */
public class TestUUID {
    public static void main(String[] args) {

        String raw = UUID.randomUUID().toString();
        System.out.println(raw);
        String remove = StringUtils.remove(raw, "-");

        System.out.println(raw);
        System.out.println(remove);

    }
}
