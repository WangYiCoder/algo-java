package study.algorithm.sort;

import java.util.Comparator;

public class CheckerComparator {


    public class Checker implements Comparator<Player>{

        @Override
        public int compare(Player a, Player b) {

            if (a.score > b.score){
                return -1;
            }

            if (a.score < b.score){
                return 1;
            }

            if (a.score == b.score){

                char[] name1 = a.name.toCharArray();
                char[] name2 = b.name.toCharArray();

                int minLength = name1.length > name2.length ? name2.length : name1.length;

                for (int i = 0; i < minLength; i++){

                    if (name1[i] > name2[i]){
                        return 1;
                    }

                    if (name1[i] < name2[i]){
                        return -1;
                    }

                    if (name1[i] == name2[i]){
                        continue;
                    }

                }

                if (name1.length < name2.length){
                    return -1;
                }

                if (name1.length > name2.length){
                    return 1;
                }

            }
            return 0;
        }
    }


    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

    }

}
