package study.algorithm.dp;

public class WinterLength {

    public int solution(int[] T) {
        // write your code in Java SE 8

        //input check
        if (T == null || T.length < 1){
            return 0;
        }
        if (T.length == 1){
            return 1;
        }


        int lastWinterDay = 0;
        int firstSummerDay = T.length - 1;

        //move pointer from right to left, till find a day that temperature is lower than the max winter temperature
        while (true){
            if (firstSummerDay == lastWinterDay){
                return 1;
            }

            if (T[lastWinterDay] >= T[firstSummerDay]){
                break;
            }

            firstSummerDay--;
        }

        int maxWinterTemp = T[0];
        out :while (true){
            firstSummerDay++;
            if (firstSummerDay > T.length - 1){
                return T.length;
            }
            for (int i = lastWinterDay + 1; i < firstSummerDay; i ++){
                if (T[i] > maxWinterTemp){
                    maxWinterTemp = T[i];
                }
            }

            lastWinterDay = firstSummerDay - 1;

            for (int j = firstSummerDay; j < T.length - 1; j++){
                if (T[j] <= maxWinterTemp){
                    firstSummerDay = j;
                    continue out;
                }
            }

            break ;

        }

        return lastWinterDay + 1;
    }
}
