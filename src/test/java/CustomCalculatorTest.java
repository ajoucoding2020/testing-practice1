import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.added(10,15);

        /* 이곳에 테스트 코드를 작성하세요. */
//        assertTrue(result == 25);
//        assertThat(result, is(25));
        assertFalse(result == 24);
        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
//        int result = customCalculator.subtract(23,10);
        int negativeResult = customCalculator.subtract(10,23);

        /* 이곳에 테스트 코드를 작성하세요. */
//        assertTrue(result == 13);
//        assertFalse(result == 13);
//        assertThat(result, is(13));
//        System.out.println("result :: " + result);
        assertTrue( negativeResult < 0);
        System.out.println("result :: " + negativeResult);
    }

    @Test
    public void 빼기테스트(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertTrue(result != 50);
//        assertFalse(result ==12);
        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
//        assertTrue(result == 45);
        assertFalse(result < 0);
//        assertThat(result, is(45));
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
//        assertTrue(result == 5);
        assertEquals(5, result);
//        assertThat(result, is(5));
        System.out.println("result :: " + result);
    }

    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(5000);
        for(int i = 0; ; i++) {
            Thread.sleep(5000);
        }
    }

    @Test(timeout = 3000)
    public void 시간제한체크() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyIndexOutOfBoundsException() {
        new ArrayList<Object>().get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tesetIsEmptyIndexOutOfBoundsException() {
        new ArrayList<Object>().get(0);
    }

    @Test
    public void testMethod() {
        ArrayList<Object> myList = new ArrayList<Object>();
        assertThat(myList, is(empty()));
    }

    @Test
    public void isEmptyArray() {
        ArrayList<Object> myList = new ArrayList<Object>();
        assertThat(myList, is(empty()));
    }

}