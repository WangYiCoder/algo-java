package study.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by EricWang on 2019/11/26 6:25 PM.
 */
public class TestDateFormat {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
