package pages;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExamplePage extends BasePage {

    public ExamplePage(WebDriver webDriver){
        super(webDriver);
    }

    private final By exampleLocator = By.xpath("//tag[@attribute='value']");

    public boolean checkExampleLocator(){
        return true;
    }
}
