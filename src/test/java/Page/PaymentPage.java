package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor
    public PaymentPage(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //declarar localizadores
    @FindBy (tagName = "h2") private WebElement txtPagoExitoso;
    @FindBy (xpath = "//td[2]/h3/strong") private WebElement txtOrden;
    @FindBy(xpath = "//a[@class='button special']") private WebElement btnHome;

    //crear metodos para utilizar
    public void ValidarPagoExitoso() {
        wait.until(ExpectedConditions.visibilityOf(txtPagoExitoso));
        txtPagoExitoso.isDisplayed();
        System.out.println("El texto de pago exitoso es: " + txtPagoExitoso.getText());
    }

    public void CapturarOrden() {
       txtOrden.getText();
       System.out.println("El numero de orden de compra es: " + txtOrden.getText());
    }

    public void ClickHome() {
        btnHome.click();
    }
}

