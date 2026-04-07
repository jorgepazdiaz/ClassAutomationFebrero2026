package Definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void setUp() {
        // Leer propiedad del sistema: -Dheadless=true  (por defecto true)
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true")); //true para headless, false para UI
        // Opciones recomendadas
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            // Modo headless moderno (Chrome 109+)
            options.addArguments("--headless=new");
            // tamaño de ventana para que los elementos aparezcan igual que en UI
            options.addArguments("--window-size=1920,1080");
        } else {
            // Si NO es headless, puedes quitar estas opciones o dejarlas
            options.addArguments("--start-maximized");
        }
        // Opciones útiles en local y CI
        options.addArguments("--disable-gpu");                 // evita problemas de render (Windows)
        options.addArguments("--no-sandbox");                  // necesario en algunos contenedores/CI
        options.addArguments("--disable-dev-shm-usage");       // evita errores en contenedores con /dev/shm pequeño
        options.addArguments("--remote-allow-origins=*");      // evita errores en algunas versiones de ChromeDriver
        // options.setImplicitWaitTimeout(Duration.ofSeconds(10)); // si quieres setear timeouts globales (Selenium 4+)
        // Crear driver con las opciones
        driver = new ChromeDriver(options);
        // En headless maximize() no tiene efecto; usamos window-size arriba.
        if (!headless) {
            driver.manage().window().maximize();
        }
    }

    @After
    public static void tearDown() {
        driver.manage().deleteAllCookies();
        //driver.quit();
    }
}
