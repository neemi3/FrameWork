package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException
{
	
prop = new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\neemi\\E2EProject\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");

if(browserName.equals("chrome"))
{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	
}
else if (browserName.equals("firefox"))
{
	WebDriverManager.firefoxdriver().setup();
	driver= new FirefoxDriver();
}
else if (browserName.equals("IE"))
{
	WebDriverManager.edgedriver().setup();
	driver= new EdgeDriver();
	}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}

//screenshot
public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}

	
}

