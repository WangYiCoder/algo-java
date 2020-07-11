package study.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

public class MissingReservation {

    public static void main(String[] args) {

    }

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here

        List<Reservation> result = new ArrayList<Reservation>();
        Map<Integer,Integer> firstReservationMap = convertReservationListToMap(firstReservationList);
        Map<Integer,Integer> secondReservationMap =convertReservationListToMap(secondReservationList);
        for (Integer secondId : secondReservationMap.keySet()){
            Integer foundReservation = firstReservationMap.get(secondId);
            if (foundReservation == null){
                result.add(new Reservation(secondId,secondReservationMap.get(secondId)));
            }
        }


        return result.stream().sorted(new Comparator<Reservation>() {
            @Override
            public int compare(Reservation o1, Reservation o2) {
                return o1.getTime() - o2.getTime();
            }
        }).map(reservation -> reservation.getId())
                .collect(Collectors.toList());
    }


    private static Map<Integer, Integer> convertReservationListToMap(List<List<Integer>> reservationList) {

        final Map<Integer,Integer> reservationMap = new HashMap();
        reservationList.forEach(idAndTime -> reservationMap.put(idAndTime.get(0),idAndTime.get(1)));
        return reservationMap;

    }


    public static class Reservation{

        private Integer id;

        private Integer time;

        public Reservation(Integer id, Integer time) {
            this.id = id;
            this.time = time;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }
    }
}
