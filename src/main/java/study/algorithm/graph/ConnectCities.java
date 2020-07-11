package study.algorithm.graph;

import java.util.*;

public class ConnectCities {

    public static List<Integer> connectedCities(int numCities, int threshold, List<Integer> originCities, List<Integer> destinationCities) {
        // Write your code here
        if (originCities == null || originCities.isEmpty()) {
            return null;
        }

        CityMap cityMap = new CityMap(numCities);
        int[] result = new int[originCities.size()];
        for (int i = 0; i < originCities.size(); i++) {

            Integer org = originCities.get(i);
            Integer dest = destinationCities.get(i);

            int commonDivisor = getCommonDivisor(org, dest);
            if (commonDivisor > threshold){
                Set<Integer> orgConnections = cityMap.getCityConnections().get(org);
                if (orgConnections == null){
                    orgConnections = new HashSet<>(numCities);
                    orgConnections.add(dest);
                    cityMap.getCityConnections().put(org,orgConnections);
                }else {
                    orgConnections.add(dest);
                }

                Set<Integer> destConnections = cityMap.getCityConnections().get(dest);
                if (destConnections == null){
                    destConnections = new HashSet<>(numCities);
                    destConnections.add(org);
                    cityMap.getCityConnections().put(dest,destConnections);
                }else {
                    destConnections.add(org);
                }

                result[i] = 1;
            }

        }

        for (int i = 0 ; i < originCities.size(); i ++){

            if (result[i] == 1){
                continue;
            }

            Boolean connected = checkConnection(originCities.get(i),destinationCities.get(i),cityMap);
            if (connected){
               result[i] = 1;
            }else {
                result[i] = 0;
            }
        }

        List<Integer> resultList = new ArrayList<>(result.length);

        for (int i = 0 ; i < result.length; i++){
            resultList.add(result[i]);
        }


        return resultList;
    }

    private static Boolean checkConnection(Integer org, Integer dest, CityMap cityMap) {
        Boolean connected = false;

        Set<Integer> visited = new HashSet<>(cityMap.getCityConnections().size());

        Queue<Integer> queue = new LinkedList<>();

        queue.add(org);
        visited.add(org);

        while (!queue.isEmpty()){

            Integer currentCity = queue.poll();
            Set<Integer> currentCityConnections = cityMap.getCityConnections().get(currentCity);
            if (currentCityConnections == null ){
                continue;
            }

            if (currentCityConnections.contains(dest)){
                return true;
            }

            for (Integer connectedCity : currentCityConnections){
                if (visited.contains(connectedCity)){
                    continue;
                }
                queue.add(connectedCity);
                visited.add(connectedCity);
            }
        }

        return connected;

    }

    static class CityMap{
         private Map<Integer,Set<Integer>> cityConnections;

        public CityMap(int s) {
            cityConnections = new HashMap<>(s);
        }

        public Map<Integer, Set<Integer>> getCityConnections() {
            return cityConnections;
        }
    }

    private static int getCommonDivisor(int a, int b) {

        int min = Math.min(a, b);

        for (int i = min; i >= 1; i--) {

            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int cityNumbers = 6;

        int thresHold = 1;

        List<Integer> origins = new ArrayList<>();
        //origins.add(4);
        origins.add(1);
        origins.add(2);
        origins.add(4);
        origins.add(6);

        List<Integer> destinations = new ArrayList<>();

        //destinations.add(4);
        destinations.add(3);
        destinations.add(3);
        destinations.add(3);
        destinations.add(4);

        System.out.println(connectedCities(cityNumbers,thresHold,origins,destinations));
    }
}
