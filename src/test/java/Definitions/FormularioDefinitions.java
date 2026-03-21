package Definitions;

import Page.PageButton;
import Page.PageClicks;
import Page.PageSelect;
import Page.PageTexto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class FormularioDefinitions {
    WebDriver hooks= Hooks.driver;
    //llamar a la clase a utlizar
    PageTexto texto;
    PageClicks clicks;
    PageSelect select;
    PageButton button;

    //iniciar variables en el constructor
    public FormularioDefinitions() {
        //instanciar las clases
        texto= new PageTexto(hooks);
        clicks= new PageClicks(hooks);
        select= new PageSelect(hooks);
        button= new PageButton(hooks);
    }


    //Steps
    @Given("que ingreso a la web de Novus Technology")
    public void queIngresoALaWebDeNovusTechnology() {
        Hooks.driver.get("https://novustechnology.pe/practice-form/");

    }

    @When("Ingreso el nombre")
    public void ingresoElNombre() {
        texto.IngresarNombre();
    }

    @And("Ingreso el apellido")
    public void ingresoElApellido() {
        texto.IngresarApellido();

    }

    @And("ingreso el telefono")
    public void ingresoElTelefono() {
        texto.IngresarTelefono();
    }

    @And("ingreso el correo")
    public void ingresoElCorreo() {
        texto.IngresarCorreo();
    }

    @And("ingreso el pasatiempo")
    public void ingresoElPasatiempo() {
        clicks.ClickMusica();
    }

    @And("ingreso el genero")
    public void ingresoElGenero() {
        clicks.clickMasculino();
    }

    @And("ingreso un documento")
    public void ingresoUnDocumento() {
        clicks.CargarDocumento();
    }

    @And("selecciono el departamento")
    public void seleccionoElDepartamento() {
        select.selectDepartamento();
    }

    @And("selecciono la ciudad")
    public void seleccionoLaCiudad() {
        select.selectCiudad();
    }

    @And("selecciono el tipo de comando")
    public void seleccionoElTipoDeComando() {
        select.selectComando();
    }

    @And("doy click en enviar")
    public void doyClickEnEnviar() {
        button.ClickBotonEnviar();
    }

    @Then("se muestra un pop up con el mensaje")
    public void seMuestraUnPopUpConElMensaje() {
        texto.validarDatos();
    }

    @And("valido que el nombre sea el mismo que se ingreso en el formulario")
    public void validoQueElNombreSeaElMismoQueSeIngresoEnElFormulario() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("valido que el apellido sea el mismo que se ingreso en el formulario")
    public void validoQueElApellidoSeaElMismoQueSeIngresoEnElFormulario() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("doy click en close")
    public void doyClickEnClose() {
        button.ClickBotonClose();
    }

    @When("ingreso los datos del formulario")
    public void ingresoLosDatosDelFormulario() {
        texto.IngresarNombre();
        texto.IngresarApellido();
        clicks.ClickMusica();
        clicks.clickMasculino();
        texto.IngresarTelefono();
        texto.IngresarCorreo();
        select.selectDepartamento();
        select.selectCiudad();
        select.selectComando();
        clicks.CargarDocumento();
    }

/// ///////Metodos para envio de datos String
    @When("ingreso el datos en nombre de {string}")
    public void ingresoElDatosEnNombreDe(String nombre) {
        texto.IngresarNombre(nombre);
    }

    @And("ingreso el datos en apellido de {string}")
    public void ingresoElDatosEnApellidoDe(String apellido) {
        texto.IngresarApellido(apellido);
    }

    @And("ingreso el pasatiempo {string}")
    public void ingresoElPasatiempo(String pasatiempo) {
        clicks.clickPasatiempo(pasatiempo);
    }

    @And("doy en el genero {string}")
    public void doyEnElGenero(String genero) {
        clicks.clickGenero(genero);
    }

    @And("ingreso el dato de telefono {string}")
    public void ingresoElDatoDeTelefono(String telefono) {
        texto.IngresarTelefono(telefono);
    }

    @And("ingreso el datos de correo {string}")
    public void ingresoElDatosDeCorreo(String correo) {
        texto.IngresarCorreo(correo);
    }

    @And("selecciono el departamento {string}")
    public void seleccionoElDepartamento(String departamento) {
         select.selectDepartamento(departamento);
    }

    @And("selecciono la ciudad {string}")
    public void seleccionoLaCiudad(String ciudad) {
        select.selectCiudad(ciudad);
    }

    @And("selecciono {string}")
    public void selecciono(String comando) {
        select.selectComando(comando);

    }

    @And("ingreso un documento desde la ruta {string}")
    public void ingresoUnDocumentoDesdeLaRuta(String ruta) {
        clicks.CargarDocumento(ruta);
    }

    @And("valido que el nombre sea el mismo que se ingreso al inicio")
    public void validoQueElNombreSeaElMismoQueSeIngresoAlInicio() {
        texto.validarNombre();
    }

    @And("valido que el apellido sea el mismo que se ingreso al inicio")
    public void validoQueElApellidoSeaElMismoQueSeIngresoAlInicio() {
        texto.validarApellido();
    }

    @When("Ingreso datos del usuario")
    public void ingresoDatosDelUsuario(DataTable dataTable) {
        List<Map<String,String >> lista=dataTable.asMaps(String.class,String.class);
        for (int i=0; i<lista.size();i++){
            texto.IngresarNombre(lista.get(i).get("nombre"));
            texto.IngresarApellido(lista.get(i).get("apellido"));
            clicks.clickPasatiempo(lista.get(i).get("pasatiempo"));
            clicks.clickGenero(lista.get(i).get("genero"));
            texto.IngresarTelefono(lista.get(i).get("telefono"));
            texto.IngresarCorreo(lista.get(i).get("correo"));
            select.selectDepartamento(lista.get(i).get("departamento"));
            select.selectCiudad(lista.get(i).get("ciudad"));
            select.selectComando(lista.get(i).get("comando"));
            clicks.CargarDocumento(lista.get(i).get("ruta"));
        }
    }

    @And("valido los datos")
    public void validoLosDatos(DataTable dataTable) {

        List<Map<String,String >> lista=dataTable.asMaps(String.class,String.class);
        for (int i=0; i<lista.size();i++){
            texto.validarNombre(lista.get(i).get("nombre"));
            texto.validarApellido(lista.get(i).get("apellido"));
        }
    }
}
