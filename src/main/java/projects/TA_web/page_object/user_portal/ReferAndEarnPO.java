package projects.TA_web.page_object.user_portal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReferAndEarnPO {
    @FindBy(xpath = "//input[@id='email']")
    public WebElement Email;
    @FindBy(xpath = "//label[@class='sc-pfmka2-0 gTWVky']")
    public WebElement ErrorEmail;
    @FindBy(xpath = "//button[.='Send']")
    public WebElement btnSend;
    public  ReferAndEarnPO(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
