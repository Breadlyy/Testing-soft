import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {
    private WebDriver driver = new ChromeDriver();
    Data getData = new Data();
    private String url = "http://automationpractice.com/index.php?id_category=5&controller=category";
    private String url1 = "http://automationpractice.com/index.php";
    private String url2 = "http://automationpractice.com/index.php?controller=contact";
    private By item = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
    private By button_add = By.id("add_to_cart");
    private By proceed = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private By proceed1 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    private By proceed2 = By.xpath("//*[@id=\"center_column\"]/form/p/button");
    private By proceed3 = By.xpath("//*[@id=\"form\"]/p/button");
    private By button_delete = By.xpath("//*[@id=\"1_1_0_0\"]");
    private By warning = By.xpath("//*[@id=\"center_column\"]/p");
    private By add_item = By.xpath("//*[@id=\"cart_quantity_up_1_1_0_0\"]");
    private By quantity = By.xpath("//*[@id=\"product_1_1_0_0\"]/td[5]/input[1]");
    private By button_tshirts = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
    private By email_input = By.xpath("//*[@id=\"email\"]");
    private By email_input2 = By.xpath("//*[@id=\"email\"]");
    private By password_input = By.xpath("//*[@id=\"passwd\"]");
    private By sign_in = By.xpath("//*[@id=\"SubmitLogin\"]");
    private By check = By.xpath("//*[@id=\"cgv\"]");
    private By check_span = By.xpath("//*[@id=\"uniform-cgv\"]/span");
    private By selector_subject = By.xpath("//*[@id=\"id_contact\"]");
    private By subject = By.xpath("//*[@id=\"id_contact\"]/option[2]");
    private By order_reference = By.xpath("//*[@id=\"id_order\"]");
    private By message_input = By.xpath("//*[@id=\"message\"]");
    private By button_send = By.xpath("//*[@id=\"submitMessage\"]");

    @Test
    public void isItemPresent()
    {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(item).click();
        driver.findElement(button_add).click();
        try {
            Thread.sleep(4500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(proceed).click();
        Assertions.assertEquals(true, isAttribtuePresent(driver.findElement(By.cssSelector("#order-detail-content")), "id"));
    }
    @Test
    public void deleteItem()
    {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(item).click();
        driver.findElement(button_add).click();
        try {
            Thread.sleep(4500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(proceed).click();
        driver.findElement(button_delete).click();
        Assertions.assertEquals(true, isAttribtuePresent(driver.findElement(warning), "id"));
    }
    @Test
    public void checkQuantityOfItems()
    {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(item).click();
        driver.findElement(button_add).click();
        try {
            Thread.sleep(3500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(proceed).click();
        driver.findElement(add_item).click();
        driver.findElement(add_item).click();
        try {
            Thread.sleep(3500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Assertions.assertEquals("3", driver.findElement(quantity).getAttribute("value"));
    }
    @Test public void BuyItem()
    {
        driver.get(url1);
        driver.manage().window().maximize();
        driver.findElement(button_tshirts).click();
        driver.findElement(item).click();
        driver.findElement(button_add).click();
        try {
            Thread.sleep(3500);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.findElement(proceed).click();
        driver.findElement(proceed1).click();
        driver.findElement(email_input).sendKeys(getData.email);
        driver.findElement(password_input).sendKeys(getData.password);
        driver.findElement(sign_in).click();
        driver.findElement(proceed2).click();
        driver.findElement(check).click();
        Assertions.assertEquals("checked", driver.findElement(check_span).getAttribute("class"));
        driver.findElement(proceed3).click();

    }
    @Test public void ContactUs()
    {
        driver.get(url2);
        driver.findElement(selector_subject).click();
        driver.findElement(subject).click();
        driver.findElement(email_input2).sendKeys(getData.email);
        driver.findElement(order_reference).sendKeys(getData.order_reference);
        driver.findElement(message_input).sendKeys(getData.message);
        driver.findElement(button_send).click();
    }
    private boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

}
