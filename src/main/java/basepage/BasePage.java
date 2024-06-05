package basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    private final long defaultWaitTime = 20;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement getWebElement(By by){
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitTime));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElement(by);
    }

    public List<WebElement> getWebElements(By by){
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(defaultWaitTime));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElements(by);
    }

    public WebElement getWebElement(By by, int i){
        return getWebElements(by).get(i);
    }

    public void click(By by){
        try {
            getWebElement(by).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click(By by, int i){
        try {
            getWebElement(by, i).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isDisplayed(By by){
        try {
            return getWebElement(by).isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDisplayed(By by, int i){
        try {
            return getWebElement(by, i).isDisplayed();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnable(By by){
        try {
            return getWebElement(by).isEnabled();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnable(By by, int i){
        try {
            return getWebElement(by, i).isEnabled();
        }   catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void sendKey(By by, String key){
        try {
            getWebElement(by).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key, int i){
        try {
            getWebElement(by, i).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clear(By by){
        try {
            getWebElement(by).clear();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clear(By by, int i){
        try {
            getWebElement(by, i).clear();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(By by){
        try {
            return getWebElement(by).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getText(By by, int i){
        try {
            return getWebElement(by, i).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getTexts(By by){
        List<WebElement> webElementList = getWebElements(by);
        List<String> stringList = new ArrayList<>();
        for (WebElement webElement : webElementList)
            stringList.add(webElement.getText());
        return stringList;
    }

    public String getAttribute(By by, String string){
        try {
            return getWebElement(by).getAttribute(string);
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getAttribute(By by, String string, int i){
        try {
            return getWebElement(by, i).getAttribute(string);
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAttributes(By by, String string){
        List<WebElement> webElementList = getWebElements(by);
        List<String> stringList = new ArrayList<>();
        for (WebElement webElement : webElementList)
            stringList.add(webElement.getAttribute(string));
        return stringList;
    }

    public String getBrowserTitle(){
        return webDriver.getTitle();
    }

    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentWindow(){
        return webDriver.getWindowHandle();
    }

    public void switchWindow(String currentWindow){
        for (String winHandle : webDriver.getWindowHandles()){
            if (!currentWindow.contentEquals(winHandle)){
                webDriver.switchTo().window(winHandle);
                break;
            }
        }
    }

    public void switchFirstWindow(String firstWindow){
        for (String winHandle : webDriver.getWindowHandles()){
            if (firstWindow.contentEquals(winHandle)){
                webDriver.switchTo().window(winHandle);
                break;
            }
        }
    }

    public void refreshPage(){
        webDriver.navigate().refresh();
    }

    public void backPage(){
        webDriver.navigate().back();
    }

    public void forwardPage(){
        webDriver.navigate().forward();
    }

    public void closeWindow(){
        webDriver.close();
    }

    public void threadSleep(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        }   catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}