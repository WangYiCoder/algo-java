package study.basic;

import java.util.Calendar;

/**
 * Created by EricWang on 2019/11/7 5:42 PM.
 */
public class TestCurrentDayOfWeek {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(System.currentTimeMillis());

        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    }
}
