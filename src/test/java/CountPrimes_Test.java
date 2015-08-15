import com.programapprentice.app.CountPrimes_204;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 11:20 AM
 */
public class CountPrimes_Test {
    CountPrimes_204 obj = new CountPrimes_204();

    @Test
    public void test1() {
        int n = 1500000;
        int expected = 114156;
        int actual = obj.countPrimes(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 1500000;
        int expected = 114156;
        int actual = obj.countPrimes_tradition(n);
        assertEquals(expected, actual);
    }
}
