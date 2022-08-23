package lecture4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

//    На вход дается число.
//    Если число кратно 3 - возвращается T,
//    если кратно 5, то M, а если 15 то S.


    @Test
    public  void Test1() {
        Assert.assertEquals(getData(3),"T", "Values are different");    }

    @Test
    public  void Test2() {
        Assert.assertEquals(getData(5),"M", "Values are different");    }


    @Test
    public  void Test3() {
        Assert.assertEquals(getData(15),"S", "Values are different");    }

    @Test
    public  void Test4() {
        Assert.assertTrue(getData(2).isEmpty(), "Values are different");    }



    private String getData(int value) {

        if (value % 3 == 0 && value % 15 != 0)
            return "T";
        if (value % 5 == 0 && value % 15 != 0)
            return "M";
        if (value % 15 == 0)
            return "S";

        return "";

    }


@Test
public  void myFirstTest() {
    System.out.println("Hello World!");
}


}
