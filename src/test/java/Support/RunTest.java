package Support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        glue = "Definitions",
        tags = "@Prueba4",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true
)
public class RunTest {
    @AfterClass
    public static void generarReporte() {
        try {
            java.io.File json = new java.io.File("target/cucumber-report/cucumber.json");
            if (!esperarJson(json, 10_000)) {
                System.err.println("No se encontro target/cucumber-report/cucumber.json a tiempo.");
                return;
            }

            String os = System.getProperty("os.name").toLowerCase();
            String[] cmd = os.contains("win")
                    ? new String[]{"cmd.exe", "/c", "npm run report"}
                    : new String[]{"/bin/bash", "-c", "npm run report"};

            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.directory(new java.io.File(System.getProperty("user.dir")));

            Process process = pb.inheritIO().start();
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("La generacion del reporte fallo. Codigo de salida: " + exitCode);
                return;
            }

            abrirReporte();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean esperarJson(java.io.File json, long timeoutMs) throws InterruptedException {
        long end = System.currentTimeMillis() + timeoutMs;
        while (System.currentTimeMillis() < end) {
            if (json.exists() && json.length() > 0) {
                return true;
            }
            Thread.sleep(250);
        }
        return false;
    }

    private static void abrirReporte() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        String rutaReporte = "target/cucumber-html-report/index.html";

        if (os.contains("win")) {
            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start " + rutaReporte});
        } else if (os.contains("mac")) {
            Runtime.getRuntime().exec(new String[]{"/usr/bin/open", rutaReporte});
        } else {
            Runtime.getRuntime().exec(new String[]{"xdg-open", rutaReporte});
        }
    }
}