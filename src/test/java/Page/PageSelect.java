package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSelect {

    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor

    public PageSelect(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Declarar los localizadores a utilizar
    @FindBy (id="department") private WebElement selectDepartamento;
    @FindBy (id="city") private WebElement selectCiudad;
    @FindBy (id="commands") private WebElement selectComando;

    //crear los metodos para seleccionar
    public void selectDepartamento() {
        new Select(selectDepartamento).selectByValue("LIMA");
    }

    public void selectDepartamento(String departamento) {
        new Select(selectDepartamento).selectByValue(departamento);
    }

    public void selectCiudad() {
        new Select(selectCiudad).selectByValue("CAÑETE");
    }

    public void selectCiudad(String ciudad) {
        new Select(selectCiudad).selectByValue(ciudad);
    }


    public void selectComando() {
        new Select(selectComando).selectByVisibleText("Switch Commands");
    }
    public void selectComando(String comando) {
        new Select(selectComando).selectByVisibleText(comando);
    }

}
