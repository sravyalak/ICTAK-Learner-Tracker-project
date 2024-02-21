package kkem.com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsers {
	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
	}

	public void Adminadduser() {
		WebElement adduser = driver.findElement(By.xpath("//button[@type='button'and contains(@class, 'btn-success')]"));
		
		adduser.click();
	}

	public void setName(String name) {
		WebElement uname = driver.findElement(By.xpath("//input[@id='name']"));
		if (!uname.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		uname.clear();
		}
		uname.sendKeys(name);
	}

	public void setEmail(String ema) {
		WebElement email = driver.findElement(By.xpath("//input[@id='email' and @class='form-control']"));
		if (!email.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		
		email.clear();
		}
		email.sendKeys(ema);
	}
	public String UpdateEmail(String ema)
	{
		WebElement email = driver.findElement(By.xpath("//input[@id='email' and @class='form-control' and @name='email']"));

		String textBoxValue = email.getAttribute("value");
		return textBoxValue;
	}

	public void setUser(String username) {
		WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
		if (!user.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		user.clear();
		}
		user.sendKeys(username);
	}

	public void setPass(String password) {
		WebElement pass = driver.findElement(By.xpath("//input[@id='password' and @class='form-control']"));
		if (!pass.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		pass.clear();
		}
		pass.sendKeys(password);
	}

	public void setRoll() {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='roleInputs']")));
		select.selectByVisibleText("Placement Officer");
	}
	public void Submit()
	{
		WebElement sub= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		sub.click();
	}
	public void Dasboard()
	{
		WebElement dash= driver.findElement(By.xpath("//button[@class='btn btn-warning' and text()='Back to Dashboard']"));
		dash.click();
	}
	public void popup1()
	{
	WebElement popupmsg=driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", popupmsg);
	//driver.switchTo().alert().accept();
	}
	public void Update()
	{
		WebElement update= driver.findElement(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
		update.click();
	}
	public void UpdateRoll() 
	{
		Select select = new Select(driver.findElement(By.xpath("//select[@name='roleInputs']")));
		select.selectByVisibleText("Training Head ");
	}
	public void PageLink() throws InterruptedException
	{
		WebElement pl= driver.findElement(By.xpath("//span[@class='page-link' and text()='73']"));
		scrollIntoView(pl);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(pl));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pl);
		//pl.click();
	}
	
	public void Delete()
	{
		WebElement delete= driver.findElement(By.xpath("(//button[@class='btn btn-danger btn btn-primary']/ion-icon[@name='close-circle'])[3]"));
		delete.click();
	}
	public String Blankusername()
	{
		String msg= driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger']")).getText();
		return msg;
	}
	public String Invalidusername()
	{
		String msg= driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger' and string-length(.) >= 8')]")).getText();
		return msg;
	}
	public void scrollIntoView(WebElement element) throws InterruptedException {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
}
}


