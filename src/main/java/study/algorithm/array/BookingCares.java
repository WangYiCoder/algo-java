package study.algorithm.array;

import java.util.*;

public class BookingCares {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        // Write your code here
        Map<Integer,CallLog> callLogMap = new HashMap<>();

        for (List<Integer> sourceCallLog : employeeCalls){

            Integer id = sourceCallLog.get(0);
            CallLog existedLogInMap = callLogMap.get(id);
            if (existedLogInMap == null){
                CallLog callLog = new CallLog(id);
                TreeMap<Integer,Integer> logs = new TreeMap<>();
                logs.put(sourceCallLog.get(1),sourceCallLog.get(2));
                callLog.setLogs(logs);
                callLogMap.put(id,callLog);
                continue;
            }

            existedLogInMap.getLogs().put(sourceCallLog.get(1),sourceCallLog.get(2));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer staffId : callLogMap.keySet()){
            CallLog callLog = callLogMap.get(staffId);

            TreeMap<Integer, Integer> logs = callLog.getLogs();
            Integer lastEndTime = null;
            int breakCount = 0;
            for (Integer startTime : logs.keySet()){
                if (lastEndTime == null){
                    lastEndTime = logs.get(startTime);
                    continue;
                }

                if (startTime > lastEndTime){
                    breakCount++;
                }

                lastEndTime = logs.get(startTime);
            }

            if (breakCount < k){
                List<Integer> lackBreakStaff = new ArrayList<>();
                lackBreakStaff.add(staffId);
                lackBreakStaff.add(breakCount);
                result.add(lackBreakStaff);
            }


        }


        return result;
    }

    public static class CallLog{

        private Integer id;

        private TreeMap<Integer,Integer> logs;

        public CallLog(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public TreeMap<Integer, Integer> getLogs() {
            return logs;
        }

        public void setLogs(TreeMap<Integer, Integer> logs) {
            this.logs = logs;
        }
    }



}
