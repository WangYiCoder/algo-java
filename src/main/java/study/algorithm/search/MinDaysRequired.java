package study.algorithm.search;

public class MinDaysRequired {

    static long minTime(long[] machines, long goal) {


        long fastest = machines[0];
        long slowest = machines[0];
        for (int i = 0; i < machines.length; i++){

            if (machines[i] < fastest){
                fastest = machines[i];
            }

            if (machines[i] > slowest){
                slowest = machines[i];
            }
        }

        long startDays = goal * fastest / machines.length;
        long endDays = goal * slowest / machines.length;


        while (true){
            long totalProduced = 0;
            if (startDays == endDays){
                return startDays;
            }

            if (endDays - startDays == 1){

                for (int i = 0; i < machines.length; i++){
                    long daysForOneProduct = machines[i];
                    totalProduced = totalProduced + (startDays/daysForOneProduct);
                }

                if (totalProduced >= goal){
                    return startDays;
                }else {
                    return endDays;
                }
            }

            long middleDays;
            if ((startDays + endDays) % 2 == 0){
                middleDays = (startDays + endDays) / 2;
            }else {
                middleDays = (startDays + endDays - 1)/2;
            }

            //calulate how many produced in current days

            for (int i = 0; i < machines.length; i++){
                long daysForOneProduct = machines[i];
                totalProduced = totalProduced + (middleDays/daysForOneProduct);
            }

            if (totalProduced < goal){
                startDays = middleDays;
                continue;
            }

            if (totalProduced >= goal){
                endDays = middleDays;
            }

        }

    }
}
