import com.programapprentice.app.FactorialTrailingZeros_172;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 7:07 PM
 */
public class FactorialTrailingZeros_Test {
    FactorialTrailingZeros_172 obj = new FactorialTrailingZeros_172();

    @Test
    public void test1() {
        int n = 1808548329;
        int expected = 452137076;
        int actual = obj.trailingZeroes(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 10;
        int expected = 2;
        int actual = obj.trailingZeroes(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 25;
        int expected = 6;
        int actual = obj.trailingZeroes(n);
        assertEquals(expected, actual);
    }


}
