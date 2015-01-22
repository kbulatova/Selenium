import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SomeTest {

    WebDriver driver;

    @Before
    public void set_up() {
        driver = new FirefoxDriver();//create new instance of firefoxdriver class from selenium library
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void log_in_to_facebook() {
        driver.get("http://www.facebook.com");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.id("loginbutton"));

        email.sendKeys("somesoft1@gmail.com");
        password.sendKeys("qwerty546");
        loginButton.click();

        WebElement loginInfo = driver.findElement(By.className("fbxWelcomeBoxName"));

        Assert.assertNotNull(loginInfo);
        Assert.assertEquals(loginInfo.getText(), "Vitalii Ivanov");
    }

    @Test
    public void log_out_of_facebook() {
        // todo: finish the test
    }


}