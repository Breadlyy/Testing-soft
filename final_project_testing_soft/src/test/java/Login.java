import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login extends Data{

    private By login = By.className("login");
    private By login_email = By.id("email");
    private By login_password = By.id("passwd");
    private By button_submit_login = By.id("SubmitLogin");

    @Test
    public void login()
    {
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.manage().window().maximize();
        driver.findElement(login).click();
        driver.findElement(login_email).sendKeys(getData.email);
        driver.findElement(login_password).sendKeys(getData.password);
        driver.findElement(button_submit_login).click();
    }
}
