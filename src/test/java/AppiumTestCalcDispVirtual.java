import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTestCalcDispVirtual {

    AndroidDriver<WebElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        DesiredCapabilities dc = new DesiredCapabilities();

        //Establecemos el nombre para la automatizacion
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        //Establecemos el nombre de la plataforma sobre la cual trabajaremos
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //Establecemos la version de la plataforma a utilizar, en este caso Android 9.0
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
        //Establecemos el nombre del dispositivo a utilizar, ya sea emulador o no
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");


        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<WebElement>(url, dc);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    //driver
    @Test
    public void testResta() throws Exception {

        driver.findElementById("com.android.calculator2:id/digit_5").click();
        driver.findElementById("com.android.calculator2:id/op_sub").click();
        driver.findElementById("com.android.calculator2:id/digit_2").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        String resultadoOperacion = driver.findElementById("com.android.calculator2:id/result").getText();

        assert resultadoOperacion.equals("3"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 3";
    }

    @Test
    public void testMultiplicacion() throws Exception {

        driver.findElementById("com.android.calculator2:id/digit_8").click();
        driver.findElementById("com.android.calculator2:id/op_mul").click();
        driver.findElementById("com.android.calculator2:id/digit_2").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        String resultadoOperacion = driver.findElementById("com.android.calculator2:id/result").getText();

        assert resultadoOperacion.equals("16"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 24";
    }

    @Test
    public void testSuma() throws Exception {

        driver.findElementById("com.android.calculator2:id/digit_7").click();
        driver.findElementById("com.android.calculator2:id/op_add").click();
        driver.findElementById("com.android.calculator2:id/digit_1").click();
        driver.findElementById("com.android.calculator2:id/digit_4").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        String resultadoOperacion = driver.findElementById("com.android.calculator2:id/result").getText();

        assert resultadoOperacion.equals("21"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 11";
    }
    @Test
    public void testDivision() throws Exception {

        driver.findElementById("com.android.calculator2:id/digit_9").click();
        driver.findElementById("com.android.calculator2:id/op_div").click();
        driver.findElementById("com.android.calculator2:id/digit_3").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        String resultadoOperacion = driver.findElementById("com.android.calculator2:id/result").getText();
        assert resultadoOperacion.equals("3"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 3";
    }

    @Test
    public void testLetras() throws Exception {

        driver.findElementById("com.android.calculator2:id/clr").click();
        driver.findElementById("com.android.calculator2:id/formula").click();
        driver.findElementById("com.android.calculator2:id/formula").sendKeys("Hola");

        WebElement Texto = driver.findElementById("com.android.calculator2:id/formula");

        Texto.click();
        Texto.sendKeys("QV");
        driver.findElementById("com.android.calculator2:id/op_mul").click();
        driver.findElementById("com.android.calculator2:id/digit_4").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        String resultadoOperacion = driver.findElementById("com.android.calculator2:id/result").getText();
        driver.findElementById("com.android.calculator2:id/formula").clear();

        assert resultadoOperacion.equals("Bad expression"):"Actual value is : "+resultadoOperacion+" did not match with expected value: Bad expression";
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}

