package kkem.com.test;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import kkem.com.utils.PageUtils;

public class TestBaseClass extends PageUtils{
	WebDriver driver;
	public static Properties prop=null;
	@BeforeTest
	public void Setup() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\sravy\\eclipse-workspace\\learnertracker\\learneartracker\\config.properties");
		prop.load(ip);
		driver=new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		PageUtils.waitForPageLoad(driver, 10);
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
    @AfterSuite
	public void afterTest() 
	{
      
        if (driver != null) 
        {
            driver.quit();
        }
	
	 

	}

	}


