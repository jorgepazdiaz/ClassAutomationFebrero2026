package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitarioPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor
    public UtilitarioPage(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void cambiaVentana() {
        String ventanaPrincipal = driver.getWindowHandle();
        for (String ventana : driver.getWindowHandles()) {
            if (!ventana.equals(ventanaPrincipal)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

    //cerra venta actual y volver a la anterior
    public void cerrarVentana() {
        driver.close();
        String ventanaPrincipal = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(ventanaPrincipal);
    }
}
