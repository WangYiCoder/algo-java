package study.basic;

import java.util.Calendar;

/**
 * Created by EricWang on 2019/11/7 5:01 PM.
 */
public class TestCalDateDiff {

    public static void main(String[] args) {

        System.out.println(dateDiffInDaysToNow(1541389993000L));

    }

    public static int dateDiffInDaysToNow(long oldTime){

        Calendar currentCalender = Calendar.getInstance();
        currentCalender.setTimeInMillis(System.currentTimeMillis());

        Calendar oldCalendar = Calendar.getInstance();
        oldCalendar.setTimeInMillis(oldTime);

        int currentYear = currentCalender.get(Calendar.YEAR);
        int currentDayinYear = currentCalender.get(Calendar.DAY_OF_YEAR);

        int oldYear = oldCalendar.get(Calendar.YEAR);
        int oldDayInYear = oldCalendar.get(Calendar.DAY_OF_YEAR);


        if (currentYear == oldYear){
            return currentDayinYear - oldDayInYear;
        }else {
            int  daysInyear = 0;

            for (int i = oldYear; i < currentYear ; i++){
                if( i%4 == 0 ){
                    daysInyear += 366;
                }else {
                    daysInyear += 365;
                }
            }

            return currentDayinYear - oldDayInYear + daysInyear;
        }

    }
}
