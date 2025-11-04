package testBase;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.net.URL;
// etc.
import java.text.SimpleDateFormat;


public class BaseClass {
		
public  WebDriver driver;
public Logger logger;
public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}else {
					System.out.println("No matching os");
					return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome" : cap.setBrowserName("chrome");break;
			case "edge"	: cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox" 	: cap.setBrowserName("firefox"); break;
			default:
		        System.out.println("Invalid browser name!");
		        return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch(br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default:System.out.println("Invalid browser");
			return;
			}
		}
		
		
		
				
				
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		
	} 
	
	@AfterClass(groups= {"Sanity","Master"})
	public void teardown(){
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomeAlphaNumeric() {
		
		String password1=RandomStringUtils.randomAlphanumeric(5);
		String password2=RandomStringUtils.randomNumeric(5);
		
		
		return (password1+'@'+password2);
	}

	@SuppressWarnings("deprecation")
	public String randomeNumber() {
		String phoneno=RandomStringUtils.randomNumeric(10);
		return phoneno;
	}

	public String randomeString() {
		String alnumber=RandomStringUtils.randomAlphanumeric(5);
		return alnumber;
	}
	
	public String captureScreen(String tname) {
		
		String timestamp=new SimpleDateFormat("yyyyMMDDhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots"+ tname +"-"+timestamp+".png";
		File targetFile=new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		return targetFilePath;
		
		
		
		
		
		
		
	}
}
