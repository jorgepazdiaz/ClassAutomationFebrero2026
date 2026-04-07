package Support;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/Feature",
        glue = "Definitions",
        tags = "@Prueba6",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true
)

public class RunCucumberTest {
    @AfterClass
    public static void finish() {
        try {
            System.out.println("Generando Reporte...");

            String os = System.getProperty("os.name").toLowerCase();
            String[] cmd;

            if (os.contains("win")) {
                cmd = new String[]{"cmd.exe", "/c", "npm run report"};
            } else {
                cmd = new String[]{"/bin/bash", "-c", "npm run report"};
            }


            // Ejecuta el comando y espera a que termine
            Process process = new ProcessBuilder(cmd)
                    .inheritIO() // muestra el output en consola
                    .start();


            process.waitFor(); // <- espera que termine la ejecución del reporte


            System.out.println("Reporte generado con éxito ");


            //  Abrir el reporte automáticamente
            abrirReporteAutomaticamente();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void abrirReporteAutomaticamente() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();


        // Ruta del archivo HTML del reporte (ajústala según tu proyecto)
        String rutaReporte = "target/cucumber-html-report/index.html";


        if (os.contains("win")) {
            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start " + rutaReporte});
        } else if (os.contains("mac")) {
            Runtime.getRuntime().exec(new String[]{"/usr/bin/open", rutaReporte});
        } else {
            Runtime.getRuntime().exec(new String[]{"xdg-open", rutaReporte}); // Linux
        }


        System.out.println("Reporte abierto automáticamente 🔥");
    }
}

