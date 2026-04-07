package Definitions;

import Page.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

public class CarritoDefinition {
    MenuPage menu;
    DatosTarjetaPage datos;
    UtilitarioPage utilitario;
    HomePage home;
    FormularioPagoPage ingresaDatos;
    PaymentPage orden;

    public CarritoDefinition() {
        menu= new MenuPage(Hooks.driver);
        datos= new DatosTarjetaPage(Hooks.driver);
        utilitario= new UtilitarioPage(Hooks.driver);
        home= new HomePage(Hooks.driver);
        ingresaDatos= new FormularioPagoPage(Hooks.driver);
        orden= new PaymentPage(Hooks.driver);
    }

    @Given("el usuario ingresa a la pagina de productos")
    public void elUsuarioIngresaALaPaginaDeProductos() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("el usuario obtiene el numero de tajeta")
    public void elUsuarioObtieneElNumeroDeTajeta() {
        menu.ClickGenerarTarjeta();
        utilitario.cambiaVentana();
        datos.setCapturaTtarjeta();

    }

    @And("el usuario obtiene el numero de CVV")
    public void elUsuarioObtieneElNumeroDeCVV() {
        datos.setCapturarCVV();
    }

    @And("el mes y año de vencimiento")
    public void elMesYAñoDeVencimiento() {
        datos.setCapturarFecha();
        datos.setCapturarCredito();
        utilitario.cerrarVentana();

    }

    @And("el usuario agrega un productos")
    public void elUsuarioAgregaUnProductos() {
        home.CapturarPrecio();
        home.SeleccionarCantidad();
    }

    @And("da click en comprar")
    public void daClickEnComprar() {
        home.ClickComprar();
    }

    @And("ingresa el numero de tarjeta")
    public void ingresaElNumeroDeTarjeta() {
        ingresaDatos.ingresarNumeroTarjeta();
    }

    @And("ingresa el numero de CVV")
    public void ingresaElNumeroDeCVV() {
        ingresaDatos.ingresarCVV();
    }

    @And("ingresa el mes y año de vencimiento")
    public void ingresaElMesYAñoDeVencimiento() {
        ingresaDatos.ingresarMes();
        ingresaDatos.ingresarAnio();
    }

    @And("dar click en comprar")
    public void darClickEnComprar() {
        ingresaDatos.clickBotonPagar();
    }

    @Then("visualiza un mensaje de compra exitosa")
    public void visualizaUnMensajeDeCompraExitosa() {
        orden.ValidarPagoExitoso();
    }

    @And("el numero de orden de compra")
    public void elNumeroDeOrdenDeCompra() {
       orden.CapturarOrden();
    }

    @And("da click en home")
    public void daClickEnHome() {
        orden.ClickHome();
        home.ValidarHome();
    }
}
