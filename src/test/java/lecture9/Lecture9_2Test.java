package lecture9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import testNgUtils.Retry;

public class Lecture9_2Test {

    int count = 1;
    int timeout = 3;

    @Test(enabled = false, priority = 1)
    public void test1(){
        System.out.println("Hello, I'm test1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Hello, I'm test2");
    }

    @Test(timeOut = 1000, description = "Test 3 from lecture 9", expectedExceptions = {NegativeArraySizeException.class}, priority = 3 )
    public void test3(){
        pause(2);
        System.out.println("Hello, I'm test3");
    }

    @Test(dependsOnMethods = "test3", alwaysRun = true, priority = 4)
    public void test4(){
        System.out.println("Hello, I'm test4");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Hello, I'm @BeforeMethod 5 and this is my repeat #" + count);
    }

    @Test(invocationCount = 5, dependsOnMethods = "test4", threadPoolSize = 5, priority = 5)
    public void test5(){
        pause(1);
        System.out.println("Hello, I'm test5 and this is my repeat #" + count++);
    }
    //почему прошел раньше, чем тест 4?

    @Test(priority = 6, timeOut = 1000, retryAnalyzer = Retry.class)
    public void test6(){
        timeout--;
        pause(timeout);
        System.out.println("Hello, I'm test6 with timeout #" + timeout);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Hello, I'm @AfterMethod 5 and this is my repeat #" + count);
    }

    private void pause (long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
