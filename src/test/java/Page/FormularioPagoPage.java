package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioPagoPage {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor
    public FormularioPagoPage(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //declarar localizadores
    @FindBy(id = "card_nmuber") private WebElement numeroTarjeta;
    @FindBy(id = "month") private WebElement mes;
    @FindBy(id = "year") private WebElement anio;
    @FindBy(id = "cvv_code") private WebElement cvv;
    @FindBy(name = "submit") private WebElement botonPagar;

    //crear metodos para utilizar
    public void ingresarNumeroTarjeta(){
        numeroTarjeta.sendKeys(DatosTarjetaPage.tarjeta);
    }
    public void ingresarCVV(){
        cvv.sendKeys(DatosTarjetaPage.cvv);
    }

    public void ingresarMes(){
        new Select(mes).selectByVisibleText(DatosTarjetaPage.mes);
    }

    public void ingresarAnio(){
        new Select(anio).selectByVisibleText(DatosTarjetaPage.anio);
    }



    public void clickBotonPagar(){
        botonPagar.click();
    }
}
