package lecture9;

import org.testng.annotations.*;

public class Lecture9_1Test {

    @BeforeTest (groups = "test9")
    public void beforeTest(){
        System.out.println("Hello, I'm @BeforeTest");
    }
    @BeforeMethod (groups = {"test9", "test9new"})
    public void beforeMethod(){
        System.out.println("Hello, I'm @BeforeMethod");
    }
    @BeforeClass (groups = "test9")
    public void beforeClass(){
        System.out.println("Hello, I'm @BeforeClass");
    }
    @BeforeSuite (groups = "test9")
    public void beforeSuite(){
        System.out.println("Hello, I'm @BeforeSuite");
    }

    @BeforeGroups (groups = "test9")
    public void beforeGroups(){
        System.out.println("Hello, I'm @BeforeGroups");
    }

    @Test(groups = "test9")
    public void test1(){
        System.out.println("Hello, I'm @test1");
    }

    @Test (groups = "test9new")
    public void test2(){
        System.out.println("Hello, I'm @test2");
    }

    @AfterTest (groups = "test9")
    public void afterTest(){
        System.out.println("Hello, I'm @AfterTest");
    }
    @AfterMethod (groups = {"test9", "test9new"})
    public void afterMethod(){
        System.out.println("Hello, I'm @AfterMethod");
    }
    @AfterClass (groups = "test9")
    public void afterClass(){
        System.out.println("Hello, I'm @AfterClass");
    }
    @AfterSuite (groups = "test9")
    public void afterSuite(){
        System.out.println("Hello, I'm @AfterSuite");
    }

    @AfterGroups (groups = "test9")
    public void afterGroups(){
        System.out.println("Hello, I'm @AfterGroups");
    }
}
