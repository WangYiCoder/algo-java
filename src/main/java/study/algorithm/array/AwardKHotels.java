package study.algorithm.array;

import java.util.List;

public class AwardKHotels {

    public static void main(String[] args) {

    }


    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        String[] positiveKeywordsArr = positiveKeywords.split(" ");

        String[] negativeKeywordsArr = negativeKeywords.split(" ");

        return null;

    }
    public static class HotelScore{
        private Integer hotelId;

        private Integer score;

        public HotelScore(Integer hotelId) {
            this.hotelId = hotelId;
        }

        public Integer getHotelId() {
            return hotelId;
        }

        public void setHotelId(Integer hotelId) {
            this.hotelId = hotelId;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }


    }
}
