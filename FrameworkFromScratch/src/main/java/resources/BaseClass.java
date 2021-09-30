package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver( )throws IOException {
	
	 prop=new Properties();
	String proppath= System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
	System.out.println(proppath);
	FileInputStream fis =new FileInputStream(proppath);
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	
	
		
	}else if(browserName.equalsIgnoreCase("ie")) {
		
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
	}
	
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	return driver;
}
}

