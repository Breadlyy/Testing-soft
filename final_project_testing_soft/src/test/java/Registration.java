import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration extends Data {
    private By login = By.className("login");
    private By inputEmail = By.id("email_create");
    private By createAccount = By.xpath("//*[@id=\"SubmitCreate\"]");
    private By gender = By.id("id_gender1");
    private By first_name = By.id("customer_firstname");
    private By last_name = By.id("customer_lastname");
    private By pass = By.id("passwd");
    private By selector_day = By.id("days");
    private By day = By.xpath("//select[@id = 'days']//option[@value = '17']");
    private By selector_month = By.id("months");
    private By month = By.xpath("//select[@id = 'months']//option[@value = '1']");
    private By selector_year = By.id("years");
    private By year = By.xpath("//select[@id = 'years']//option[@value = '2002']");
    private By button_submit = By.id("submitAccount");
    private By address = By.id("address1");
    private By phone = By.id("phone_mobile");
    private By city = By.id("city");
    private By zip = By.id("postcode");
    private By selector_country = By.id("id_country");
    private By country = By.xpath("//select[@id = 'id_country']//option[@value = '21']");
    private By selector_state = By.id("id_state");
    private By state = By.xpath("//select[@id='id_state']//option[@value = '1']");
    @ParameterizedTest(name = "Create account with {0} email {1} fname {2} lname {3} pass")
    @CsvSource({"nattgffou-5783@yopmail.com, Josef, Sedláček, lkjh12345", "brsgfgejs3@yopmail.com, Ilon, Mask, oklaf925", "7fs8gksdgre3@yopmail.com, Yurnero, Machinegunner, faceless228", "n7fbh3erhj3@yopmail.com, Mars, Greatest, titan360"})
    public void registration(String email, String First_name, String Last_name, String password )
    {
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.manage().window().maximize();
        driver.findElement(login).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(createAccount).click();
        try {
            Thread.sleep(3500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(gender).click();
        driver.findElement(first_name).sendKeys(First_name);
        driver.findElement(last_name).sendKeys(Last_name);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(selector_day).click();
        driver.findElement(day).click();
        driver.findElement(selector_month).click();
        driver.findElement(month).click();
        driver.findElement(selector_year).click();
        driver.findElement(year).click();


        driver.findElement(address).sendKeys(getData.address);
        driver.findElement(phone).sendKeys(getData.phone);
        driver.findElement(city).sendKeys(getData.city);
        driver.findElement(zip).sendKeys(getData.zip);
        driver.findElement(selector_country).click();
        driver.findElement(country).click();
        driver.findElement(selector_state).click();
        driver.findElement(state).click();
        driver.findElement(button_submit).click();

    }
}
