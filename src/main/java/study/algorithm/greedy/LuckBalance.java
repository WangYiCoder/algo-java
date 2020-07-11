package study.algorithm.greedy;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {
        int total = 0;

        Set<LuckWrapper> descendTree = new TreeSet<>(new Comparator<LuckWrapper>() {
            @Override
            public int compare(LuckWrapper o1, LuckWrapper o2) {
                if (o1.getLuck() >= o2.getLuck()){
                    return -1;
                }
                return 1;
            }
        });



        for (int i = 0; i < contests.length; i++){

            if (contests[i][1] == 0){
                total = total + contests[i][0];
                continue;
            }

            descendTree.add(new LuckWrapper(contests[i][0]));
        }

        int index = 0;
        for (LuckWrapper luckWrapper : descendTree){
            index ++;
            if (index <= k){
                total = total + luckWrapper.getLuck();
                continue;
            }

            total = total - luckWrapper.getLuck();
        }


        return total;
    }

    static class LuckWrapper{
        private int luck;

        public LuckWrapper(int luck) {
            this.luck = luck;
        }

        public int getLuck() {
            return luck;
        }
    }
}
