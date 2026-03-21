package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageClicks {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;


    public PageClicks(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy (id="preloader") private WebElement Loading;
    @FindBy (id="music") private WebElement musica;
    @FindBy (id="sports") private WebElement deportes;
    @FindBy (id="reading") private WebElement lectura;
    @FindBy (id="male") private WebElement masculino;
    @FindBy (id="female") private WebElement femenino;
    @FindBy (id="other") private WebElement otro;
    //CARGAR DOCUMENTO
    @FindBy (id="picture") private WebElement cargarDocumento;

    public void ClickMusica(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",musica);
    }

    public void clickMasculino(){
        wait.until(ExpectedConditions.invisibilityOf(Loading));
        masculino.click();

    }

    public void CargarDocumento(){
        cargarDocumento.sendKeys("/Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf");
    }

    public void CargarDocumento(String ruta){
        cargarDocumento.sendKeys(ruta);
    }

    public void clickPasatiempo(String pasatiempo){
        wait.until(ExpectedConditions.invisibilityOf(Loading));
        if (pasatiempo.equals("deporte")) {
            deportes.click();
        } else if (pasatiempo.equals("lectura")) {

            lectura.click();
        } else {
            musica.click();
        }
    }

    public void clickGenero(String genero){
        wait.until(ExpectedConditions.invisibilityOf(Loading));
        if (genero.equals("masculino")) {
            masculino.click();
        } else if (genero.equals("femenino")) {

            femenino.click();
        } else {
            otro.click();
        }
    }
}
