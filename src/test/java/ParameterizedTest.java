import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by LiudaBalatskaya on 5/8/2017.
 */


public class ParameterizedTest {

    @DataProvider(name = "data1")
    public Object[][] createData1() {
        return new Object[][]{
                {1, 1}, {2, 1}, {4, 2}, {6, 2}, {6, 3}, {8, 2}, {8, 4}
        };
    }

    public int result;
    public Mathematics calculator;

    @BeforeMethod
    public void initializerTest() {
        System.out.println("In before the test");
        calculator = new Mathematics();
        calculator.setResult(0);
    }

    @Test(dataProvider = "data1")
    public void addCheck(int x, int y) {
        calculator.add(x,y);
        result = calculator.getResult();
        assertTrue(result==x+y);
        System.out.println("added result=" + result);
    }

    @Test(dataProvider = "data1")
    public void multiplyCheck(int x, int y){
        calculator.multiply(x,y);
        result = calculator.getResult();
        assertTrue(result==x*y);
        System.out.println("multiplied result=" + result);
    }

    @Test(dataProvider = "data1")
    public void divideCheck(int x, int y){
        calculator.divide(x,y);
        result = calculator.getResult();
        assertTrue(result==x/y);
        System.out.println("divided result=" + result);
    }

    @Test(dataProvider = "data1")
    public void deductCheck(int x, int y){
        calculator.setResult(1);
        calculator.deduct(x,y);
        result = calculator.getResult();
        assertTrue(result==x-y);
        System.out.println("deducted result=" + result);
    }

}
