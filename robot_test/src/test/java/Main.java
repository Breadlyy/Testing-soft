import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        By first_login = By.xpath("//div[@class = 'collapse navbar-collapse justify-content-end']//a[@data-cy='navbar-login-a']");
        By second_login = By.xpath("//div[@class='position-absolute w-100']//a[@class='btn btn-primary w-100']");
        By username_input = By.id("username");
        By password_input = By.id("password");
        By button_submit = By.xpath("//div[@class = 'col col-xs-12 col-sm-5']//button[@type = 'submit']");

        By pointer = By.xpath("//a[@href='/course/view.php?id=6692']");
        By button_show = By.xpath("//a[@href = '#collapse-4']");
        By button_test = By.xpath("/html/body/div[1]/div[2]/div/div/section[1]/div/div/ul/li[5]/div[3]/div[4]/ul/li[17]/div/div/div[2]/div/a\\");
        By button_try_test = By.xpath("//div[@class = 'singlebutton quizstartbuttondiv']//button[@class = 'btn btn-primary']");
        By button_start_test = By.xpath("//input[@value = 'Zahájení pokusu']");
        By question_1 = By.xpath("//textarea[@id = 'q117671:1_answer_id']");
        By question_2 = By.xpath("//input[@id = 'q117671:2_answer']");
        By question_3 = By.id("q117671_3_p1");
        By answer_3 = By.xpath("//select[@id = 'q117671_3_p1']//option[@value = '2']");
        By question_4 = By.id("q117671_4_p1");
        By answer_4 = By.xpath("//select[@id = 'q117671_4_p1']//option[@value = '7']");
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();


        driver.get(getData.getUrl);
        driver.findElement(first_login).click();
        driver.findElement(second_login).click();
        driver.findElement(username_input).sendKeys(getData.login);
        driver.findElement(password_input).sendKeys(getData.password);
        driver.findElement(button_submit).click();

        driver.findElement(pointer).click();
        driver.findElement(button_show).click();
        driver.get(getData.getUrl_test);
        driver.findElement(button_try_test).click();
        driver.findElement(button_start_test).click();

        driver.findElement(question_1).sendKeys(getData.answer_1);
        driver.findElement(question_2).sendKeys(getData.answer_2);
        driver.findElement(question_3).click();
        driver.findElement(answer_3).click();
        driver.findElement(question_4).click();
        driver.findElement(answer_4).click();
    }
}
