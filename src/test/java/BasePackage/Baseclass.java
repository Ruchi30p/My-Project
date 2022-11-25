package BasePackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.TimeUtils;
public class Baseclass {
	
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	//Step 1 
	public Baseclass() {
		
                try {		
		FileInputStream file= new FileInputStream("C:\\Users\\ruchi\\eclipse-workspace\\HRManagement\\src\\test\\java\\Environmentvariable\\Config.properties");     // to read properties of config.properties file in this constructor
                prop.load(file); }
                
                catch(FileNotFoundException e) {
                	e.printStackTrace();
        }
                catch(IOException a) {
                	a.printStackTrace();
                }
                
      //Step 2
	}
	
    public static void initiate() {
    String browsername=prop.getProperty("browser");
    
    if (browsername.equals("Chrome")) {
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver=new ChromeDriver();
    }
    	else if(browsername.equals("Firefox")) {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver=new FirefoxDriver();
    	}
    
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));
    }
    public static void screenshots(String Filename) {
    	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
    	FileUtils.copyFile(file,new File("C:\\Users\\ruchi\\eclipse-workspace\\HRManagement\\src\\test\\java\\Screenshot\\Screenshots.java"+ Filename));
    }
    catch(IOException a) {
    	a.printStackTrace();
        }
    }
}
	


