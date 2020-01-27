package study.basic;

/**
 * Created by EricWang on 2019/11/18 11:09 AM.
 */
public class TestFinally {

    public static void main(String[] args) {

      //flow();

        try {
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        }finally {
            System.out.println("C");
        }

        System.out.println("D");

    }

    public static int flow(){
        int a = 3;

        try {
            if (a > 1){
                throw new RuntimeException("hehheheh");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("dididdidi");
        }catch (Exception e) {
            System.out.println("catch by big exception");
            return 0;
        } finally {
            System.out.println("=====================execute finally");
        }


        return 1;
    }
}
