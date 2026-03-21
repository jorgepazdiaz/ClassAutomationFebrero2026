package Page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTexto {

    //declarar variables driver y wait para usarla en toda la clase.
    private WebDriver driver;
    private WebDriverWait wait;

    //declara el constructor

    public PageTexto(WebDriver d) {
        //instanciar el driver y el wait
        driver=d;
        wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private String Snombre;
    private String Sapellido;
    //declarar lo localizadores que se usan
    @FindBy (id="nombre") private WebElement Txtnombre;
    @FindBy (id="apellido") private WebElement Txtapellido;
    @FindBy (name="mobile") private WebElement Txttelefono;
    @FindBy (id="email") private WebElement Txtcorreo;
    @FindBy (id="nombreModal")  private WebElement nombreCaptura;
    @FindBy (id="apellidoModal") private WebElement apellidoCaptura;


    //crear metodo para enviar nombre con el dato en duro
    public void IngresarNombre(){
        Txtnombre.sendKeys("Jorge Erickson");
    }

    //crear metodo para enviar apellido con el dato en duro
    public void IngresarNombre(String nombre){
        Txtnombre.sendKeys(nombre);
        Snombre=nombre;
    }

    public void IngresarApellido(){
        Txtapellido.sendKeys("Paz Diaz");
    }

    public void IngresarApellido(String apellido){
        Txtapellido.sendKeys(apellido);
        Sapellido=apellido;
    }


    public void IngresarTelefono(){
        Txttelefono.sendKeys("987654321");
    }

    public void IngresarTelefono(String telefono){
        Txttelefono.sendKeys(telefono);
    }

    public void IngresarCorreo() {
        Txtcorreo.sendKeys("jpaz@test.com");
    }

    public void IngresarCorreo(String correo) {
        Txtcorreo.sendKeys(correo);
    }

    public void validarDatos(){
        wait.until(ExpectedConditions.visibilityOf(nombreCaptura));
        nombreCaptura.isDisplayed();
        apellidoCaptura.isDisplayed();
    }

    public void validarNombre(){
        wait.until(ExpectedConditions.visibilityOf(nombreCaptura));
        Assert.assertEquals(nombreCaptura.getText(),Snombre);
        System.out.println("el nombre actual es: " + nombreCaptura.getText());
        System.out.println("el nombre esperado es: " + Snombre);
    }

    public void validarApellido(){
        wait.until(ExpectedConditions.visibilityOf(apellidoCaptura));
        Assert.assertEquals(apellidoCaptura.getText(),Sapellido);
        System.out.println("el apellido actual es: " + apellidoCaptura.getText());
        System.out.println("el apellido esperado es: " + Sapellido);
    }

    public void validarNombre(String nombre){
        wait.until(ExpectedConditions.visibilityOf(nombreCaptura));
        Assert.assertEquals(nombreCaptura.getText(),nombre);
        System.out.println("el nombre actual es: " + nombreCaptura.getText());
        System.out.println("el nombre esperado es: " + nombre);
    }

    public void validarApellido(String apellido){
        wait.until(ExpectedConditions.visibilityOf(apellidoCaptura));
        Assert.assertEquals(apellidoCaptura.getText(),apellido);
        System.out.println("el apellido actual es: " + apellidoCaptura.getText());
        System.out.println("el apellido esperado es: " + apellido);
    }










}
