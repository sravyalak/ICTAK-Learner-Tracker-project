package kkem.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	WebDriver driver;
    public Logout(WebDriver driver)
    {
   	 this.driver=driver;
    }
    public void Logoutpage() throws InterruptedException
	{
		WebElement logout= driver.findElement(By.xpath("//a[@id='basic-nav-dropdown']"));
		
		
		logout.click();
	}
    public void LogoutClick()
   	{
   		WebElement logout= driver.findElement(By.xpath("//a[@data-rr-ui-dropdown-item and text()='Logout']"));
   		logout.click();
   	}
    public void scrollIntoView(WebElement element) throws InterruptedException {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
}
}


