import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SomeTest {

    WebDriver driver;

    @Before
    public void set_up() {
        driver = new FirefoxDriver();//create new instance of firefoxdriver class from selenium library
    }

    @After
    public void clean() {
        //driver.quit();
    }

    @Test
    public void log_in_to_facebook() {
        LoginToFacebook();

        WebElement loginInfo = driver.findElement(By.className("fbxWelcomeBoxName"));

        Assert.assertNotNull(loginInfo);
        Assert.assertEquals(loginInfo.getText(), "Vitalii Ivanov");
    }

    @Test     // todo: finish the test
    public void log_out_of_facebook () {
        LoginToFacebook();

        WebDriverWait wait = new WebDriverWait(driver, 40);

        WebElement logoutArrow = wait.until(ExpectedConditions.elementToBeClickable(By.id("pageLoginAnchor")));
        logoutArrow.click();

        //Wait till we see the menu. Check that first item is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.className("_54nc")));

        //Get all items with class _54nc and select the 6th one - Log Out
        List<WebElement> menuItems = driver.findElements(By.className("_54nc"));
        menuItems.get(6).click();

        //TODO: Assert that we logged out successfully
        //Assert
    }

    private void LoginToFacebook(){
        driver.get("http://www.facebook.com");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.id("loginbutton"));

        email.sendKeys("somesoft1@gmail.com");
        password.sendKeys("qwerty546");
        loginButton.click();
    }



}