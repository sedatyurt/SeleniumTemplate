package tests;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExamplePage;

public class ExampleTest extends BaseTest {

    ExamplePage examplePage;

    @Test
    public void exampleTest(){

        examplePage = new ExamplePage(webDriver);
        Assert.assertTrue(examplePage.checkExampleLocator());

    }
}
