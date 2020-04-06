import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.unitest.MathUtil;

/**
 * Created by EricWang on 2020/4/5 4:19 PM.
 */
public class MathTest {

    @Test
    @DisplayName("1 + 2 = 3")
    public void testSum(){

        MathUtil mathUtil = new MathUtil();

        int n =1;
        int m = 2;

        int sum = mathUtil.sum(n, m);

        Assertions.assertEquals(3,sum,"1 + 2 should equal 3");

    }
}
