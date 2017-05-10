import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


/**
 * Created by LiudaBalatskaya on 5/8/2017.
 */

public class MethodOrderTest {
    public int result;
    public Mathematics calculator;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("In beforeClass method");
    }

    @BeforeMethod
    public void initializerTest() {
        System.out.println("In before the test");
        calculator = new Mathematics();
        calculator.setResult(0);
    }

    @Test(priority = 3)
    public void multiply(){
        calculator.multiply(5,5);
        result = calculator.getResult();
        assertTrue(result==25);
        System.out.println("multiply test");
    }

    @Test(priority = 2)
    public void divide(){
        calculator.divide(25,5);
        result = calculator.getResult();
        assertTrue(result==5);
        System.out.println("divide test");
    }

    @Test(priority = 1)
    public void add(){
        calculator.add(2,2);
        result = calculator.getResult();
        assertTrue(result==4);
        System.out.println("add test");
    }

    @Test(priority = 4)
    public void deduct(){
        calculator.setResult(1);
        calculator.deduct(15,5);
        result = calculator.getResult();
        assertTrue(result==10);
        System.out.println("deduct test");
    }

}
