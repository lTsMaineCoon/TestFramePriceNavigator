package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.elementUtils.WaitUtils;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    protected abstract void waitForMainElements();

    public abstract void openPage(WebDriver driver);
}
