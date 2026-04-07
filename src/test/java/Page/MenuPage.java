package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor

    public MenuPage(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //mapear localizadores
    @FindBy(linkText = "Generate Card Number") private WebElement GenerarTarjeta;
    @FindBy(linkText = "Cart") private WebElement Carrito;
    @FindBy(linkText = "Check Credit Card Limit") private WebElement CheckBalance;
    @FindBy(linkText = "Guru99 Payment Gateway\n") private WebElement Home;

    //crear metodos para utilizar en duro
    public void ClickGenerarTarjeta() {
        wait.until(ExpectedConditions.elementToBeClickable(GenerarTarjeta));
        GenerarTarjeta.click();
    }

    public void ClickCarrito() {
        wait.until(ExpectedConditions.elementToBeClickable(Carrito));
        Carrito.click();
    }

    public void ClickCheckBalance() {
        wait.until(ExpectedConditions.elementToBeClickable(CheckBalance));
        CheckBalance.click();
    }

    public void ClickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(Home));
        Home.click();
    }
}
