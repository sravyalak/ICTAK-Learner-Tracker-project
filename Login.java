package kkem.com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
    public Login(WebDriver driver)
    {
   	 this.driver=driver;
    }

		public void setUsername(String username) throws InterruptedException
		{
			try
			{
			WebElement Auname = driver.findElement(By.xpath("//input[@class='form-control' and @name='username']"));
			scrollIntoView(Auname);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.elementToBeClickable(Auname));
			JavascriptExecutor js = (JavascriptExecutor) driver;
	         js.executeScript("arguments[0].click();",Auname);
			Auname.clear();
		Auname.sendKeys(username);
			}
			catch (StaleElementReferenceException e) {
			}
			}
		
		public void setpassword(String pass)
		{
			try
			{
			WebElement Apassword = driver.findElement(By.xpath("//input[@class='form-control pwd' and @name='password']"));
			Apassword.clear();
			Apassword.sendKeys(pass);
			}
			catch (StaleElementReferenceException e) {
			}
		}
		public void ClickLogin()
		{
			WebElement logclick= driver.findElement(By.xpath("//button[@class='btn btn-success w-100' and text()='Login']"));
			logclick.click();
		}
		public String Logo() throws InterruptedException
		{
			
			WebElement logo= driver.findElement(By.xpath("//img[@class='App-logo mb-2']"));
			
			if (logo.isDisplayed()) 
			{
	           String msg="logo is present";
	           return msg;
	        } 
		
			else 
	        {
				String msg="logo is not present";
		           return msg;
	        }
			
		}
		public String LoginFailed()
		{
			WebElement logclick= driver.findElement(By.xpath("//div[contains(@class, 'alert-danger') and contains(text(), 'Login Failed!!')]"));
			String loginFailedText = logclick.getText();
			return loginFailedText;
		}
		public void scrollIntoView(WebElement element) throws InterruptedException {
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
}
}


