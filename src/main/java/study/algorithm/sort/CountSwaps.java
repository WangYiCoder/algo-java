package study.algorithm.sort;

public class CountSwaps {

    public static void main(String[] args) {

    }

    static void countSwaps(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i ++){

            for (int j = 0; j < a.length - i -1; j++){

                if (a[j] > a[j+1]){
                    swap(j,j+1,a);
                    count++;
                }

            }

        }

        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);
    }

    private static void swap(int j, int i, int[] a) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
