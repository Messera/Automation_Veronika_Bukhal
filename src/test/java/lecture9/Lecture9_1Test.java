package lecture9;

import lombok.extern.log4j.Log4j;
import org.testng.Reporter;
import org.testng.annotations.*;
@Log4j
public class Lecture9_1Test {

    @BeforeTest(groups = "test9")
    public void beforeTest() {
        log.debug("Hello, I'm @BeforeTest");
    }

    @BeforeMethod(groups = {"test9", "test9new"})
    public void beforeMethod() {
        log.debug("Hello, I'm @BeforeMethod");
    }

    @BeforeClass(groups = "test9")
    public void beforeClass() {
        log.debug("Hello, I'm @BeforeClass");
    }

    @BeforeSuite(groups = "test9")
    public void beforeSuite() {
        log.debug("Hello, I'm @BeforeSuite");
    }

    @BeforeGroups(groups = "test9")
    public void beforeGroups() {
        log.debug("Hello, I'm @BeforeGroups");
    }

    @Test(groups = "test9")
    public void test1() {
        Reporter.log("Hello, I'm @test1");
        log.debug("Hello, I'm @test1");
    }

    @Test(groups = "test9new")
    public void test2() {
        log.debug("Hello, I'm @test2");
    }

    @AfterTest(groups = "test9")
    public void afterTest() {

        log.debug("Hello, I'm @AfterTest");
    }

    @AfterMethod(groups = {"test9", "test9new"})
    public void afterMethod() {
        log.debug("Hello, I'm @AfterMethod");
    }

    @AfterClass(groups = "test9")
    public void afterClass() {
        log.debug("Hello, I'm @AfterClass");
    }

    @AfterSuite(groups = "test9")
    public void afterSuite() {
        log.debug("Hello, I'm @AfterSuite");
    }

    @AfterGroups(groups = "test9")
    public void afterGroups() {
        log.debug("Hello, I'm @AfterGroups");
    }
}
