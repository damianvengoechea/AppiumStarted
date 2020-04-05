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

public class AppiumTestCalcDispReal {

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
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "124ab9a1");

        dc.setCapability("appPackage", "com.miui.calculator");
        dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        driver = new AndroidDriver<WebElement>(url, dc);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    //driver
    @Test
    public void testResta() throws Exception {

        driver.findElementById("com.miui.calculator:id/btn_5_s").click();
        driver.findElementById("com.miui.calculator:id/btn_minus_s").click();
        driver.findElementById("com.miui.calculator:id/btn_2_s").click();
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        String resultadoOperacion = driver.findElementById("com.miui.calculator:id/result").getText();

        assert resultadoOperacion.equals("= 3"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 3";
    }

    @Test
    public void testMultiplicacion() throws Exception {

        driver.findElementById("com.miui.calculator:id/btn_8_s").click();
        driver.findElementById("com.miui.calculator:id/btn_mul_s").click();
        driver.findElementById("com.miui.calculator:id/btn_2_s").click();
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        String resultadoOperacion = driver.findElementById("com.miui.calculator:id/result").getText();

        assert resultadoOperacion.equals("= 16"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 24";
    }

    @Test
    public void testSuma() throws Exception {

        driver.findElementById("com.miui.calculator:id/btn_7_s").click();
        driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
        driver.findElementById("com.miui.calculator:id/btn_1_s").click();
        driver.findElementById("com.miui.calculator:id/btn_4_s").click();
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        String resultadoOperacion = driver.findElementById("com.miui.calculator:id/result").getText();

        assert resultadoOperacion.equals("= 21"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 11";
    }
    @Test
    public void testDivision() throws Exception {

        driver.findElementById("com.miui.calculator:id/btn_9_s").click();
        driver.findElementById("com.miui.calculator:id/btn_div_s").click();
        driver.findElementById("com.miui.calculator:id/btn_3_s").click();
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        String resultadoOperacion = driver.findElementById("com.miui.calculator:id/result").getText();
        assert resultadoOperacion.equals("= 3"):"Actual value is : "+resultadoOperacion+" did not match with expected value: 11";
    }

    //@Test
    public void testLetras() throws Exception {

        WebElement Texto = driver.findElementById("com.miui.calculator:id/expression");

        Texto.click();
        Texto.sendKeys("QV");
        driver.findElementById("com.miui.calculator:id/btn_mul_s").click();
        driver.findElementById("com.miui.calculator:id/btn_4_s").click();
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        String resultadoOperacion = driver.findElementById("com.miui.calculator:id/result").getText();
        driver.findElementById("com.miui.calculator:id/expression").clear();

        assert resultadoOperacion.equals("Bad expression"):"Actual value is : "+resultadoOperacion+" did not match with expected value: Bad expression";
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
