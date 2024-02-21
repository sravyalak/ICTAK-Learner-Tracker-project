package kkem.com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPlacement {
	WebDriver driver;

	public AdminPlacement (WebDriver driver) {
		this.driver = driver;
	}
	public void Placementlink() {
		WebElement plink = driver.findElement(By.xpath("//span[@class='item-content' and text()='Placement']"));
		plink.click();
	}
	public void PlacementUpdate() throws InterruptedException {
		WebElement pupdate = driver.findElement(By.xpath("(//button[@type='button' and contains(@class, 'btn-success') and contains(@class, 'btn-primary')]/ion-icon[@name='create'])[2]"));
		
		scrollIntoView(pupdate);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(pupdate));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", pupdate);
		//pupdate.click();
	}
	public void setPlacement() {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-select' and @name='pstatus']")));
		select.selectByVisibleText("Placed");
	}
	public void PlacementSubmit() {
		WebElement sub = driver.findElement(By.xpath("//button[@class='btn btn-success' and text()='Submit']"));
		sub.click();
	}
	 
		
	
	public void scrollIntoView(WebElement element) throws InterruptedException {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
}
}


