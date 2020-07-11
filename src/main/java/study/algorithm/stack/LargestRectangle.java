package study.algorithm.stack;

import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        int[] h = new int[]{11,11,10,10,10};

        System.out.println(largestRectangle(h));
    }

    //use stack
    static long largestRectangle(int[] h) {

        long max = 0L;
        Ele[] elements = new Ele[h.length];
        Stack<Ele> lowToHigh = new Stack<>();
        out : for (int i = 0; i < h.length; i++){
            Ele ele = new Ele(i, h[i]);
            elements[i] = ele;
            if (lowToHigh.isEmpty()){
                lowToHigh.push(ele);
                ele.leftBoundary = i;
                continue;
            }

            while (true){
                Ele top = lowToHigh.peek();
                if (top.value <= h[i]){
                    if (top.value < h[i]){
                        ele.leftBoundary = top.index + 1;
                    }else {
                        ele.leftBoundary = top.leftBoundary;
                    }
                    lowToHigh.push(ele);
                    continue out;
                }

                Ele popedOut = lowToHigh.pop();
                popedOut.rightBoundary = i;

                if (lowToHigh.isEmpty()){
                    ele.leftBoundary = popedOut.leftBoundary;
                    lowToHigh.push(ele);
                    continue out;
                }
            }

        }

        Ele finalTop = lowToHigh.peek();

        int finalRightBoundary = finalTop.index + 1;

        while (!lowToHigh.isEmpty()){
            Ele popedOut = lowToHigh.pop();
            popedOut.rightBoundary = finalRightBoundary;

        }

        for (int i = 0 ; i < h.length; i++){
            Ele ele = elements[i];

            long current = ele.value * (ele.rightBoundary - ele.leftBoundary);

            if (current > max){
                max = current;
            }
        }


        return max;
    }

    static class Ele{

        int index;

        int leftBoundary;

        int rightBoundary;

        int value;

        public Ele(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    /*
    time complexity not good enough
    static long largestRectangle(int[] h) {

        long max = 0L;
        long[][] results = new long[h.length][h.length];

        out:for (int i = 0; i < h.length; i ++){

            for (int j = 0; j< h.length; j++){
                if (h[i] <= h[j]){
                    if (j == 0){
                        results[i][j] = 1L;
                        if (h[i] > max){
                            max = h[i];
                        }

                    }else {
                        long newLength = results[i][j - 1]+ 1L;
                        long newRectangle = newLength * h[i];

                        results[i][j] = newLength;
                        if(newRectangle > max){
                            max = newRectangle;
                        }
                    }
                }else {
                    results[i][j] = 0L;
                    if (j > i){
                        continue out;
                    }

                }
            }
        }


        return max;
    }*/

}
