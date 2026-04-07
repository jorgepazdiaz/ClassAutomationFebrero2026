package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatosTarjetaPage {
    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    protected static String tarjeta;
    protected static String cvv;
    protected static String mes;
    protected static String anio;
    protected static String credito;

    //declara el constructor

    public DatosTarjetaPage(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h4[1]") private WebElement capturaTtarjeta;
    @FindBy(xpath = "//h4[2]") private WebElement capturarCVV;
    @FindBy(xpath = "//h4[3]") private WebElement capturarFecha;
    @FindBy(xpath = "//h4[4]") private WebElement capturarCredito;

    public void setCapturaTtarjeta(){
        wait.until(ExpectedConditions.visibilityOf(capturaTtarjeta));
        tarjeta = capturaTtarjeta.getText();
        //quedarnos solo con los numero del tarjeta
            tarjeta = tarjeta.replaceAll("\\D+", "");
        System.out.println("El numero de tarjeta es: " + tarjeta);
    }

    public void setCapturarCVV(){
            wait.until(ExpectedConditions.visibilityOf(capturarCVV));
            cvv = capturarCVV.getText();
            //quedarnos solo con los numero del CVV
                cvv = cvv.replaceAll("\\D+", "");
            System.out.println("El numero de CVV es: " + cvv);

    }

    public void setCapturarFecha(){
        wait.until(ExpectedConditions.visibilityOf(capturarFecha));
        String fecha = capturarFecha.getText();

        // Primero separamos por "/" y luego limpiamos cada parte por separado
        String[] fechaSeparada = fecha.split("/");
        if (fechaSeparada.length < 2) {
            throw new RuntimeException("Formato de fecha inesperado: '" + fecha + "'. Se esperaba mes/año.");
        }
        mes  = fechaSeparada[0].replaceAll("\\D+", "");
        anio = fechaSeparada[1].replaceAll("\\D+", "");

        System.out.println("El mes es: " + mes);
        System.out.println("El año es: " + anio);

    }

    public void setCapturarCredito(){
            wait.until(ExpectedConditions.visibilityOf(capturarCredito));
            credito = capturarCredito.getText();

            //quedarnos solo con los numero del credito pero si tiene un punto despues del os numeros, lo dejamos
            credito = credito.replaceAll("[^\\d.]", "");
            System.out.println("El credito es: " + credito);
    }


}
