package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageButton {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor

    public PageButton(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //declarar los localizadores a utilizar
    @FindBy (xpath = "//*[@id=\"registroForm\"]/div[6]/div/button") private WebElement botonEnviar;
    @FindBy (xpath = "//*[contains(text(),'Close')]") private WebElement botonClose;


    //crear el metodo para hacer click en el boton
    public void ClickBotonEnviar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", botonEnviar);
    }

        public void ClickBotonClose() {
            botonClose.click();
        }
}
