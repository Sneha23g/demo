package miniproject;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Driversetup {
	private static WebDriver driver;
	public static String browserType;
	public static WebDriver getDriver(String browser) {
		browserType = browser;
		{
		if(browserType.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserType.equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			System.out.print("works only with chrome and edge browser");
		}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
 

	}
}