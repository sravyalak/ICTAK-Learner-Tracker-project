package kkem.com.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLearner {
	WebDriver driver;

	public AdminLearner(WebDriver driver) {
		this.driver = driver;
	}

	public void Learnslink() throws InterruptedException 
	{
		try
		{
		WebElement lear=driver.findElement(By.xpath("//span[@class='item-content' and text()='Learners']"));
		scrollIntoView(lear);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(lear));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lear);
		lear.click();
		}
		catch (StaleElementReferenceException e) {
		}
		
	}

	public void AddLearns() throws InterruptedException {
		try
		{
		WebElement lear = driver.findElement(By.xpath("//button[@class='mb-3 btn btn-success']/ion-icon[@name='person-add-outline']"));
		scrollIntoView(lear);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lear);
		lear.click();
		}
		catch (StaleElementReferenceException e) {
		}
		
	}

	// learners form
	public void setlearnerid(String id) throws InterruptedException {
		try
		{
		WebElement lid = driver.findElement(By.xpath("//input[@type='text' and @id='learnerid' and @class='form-control']"));
		scrollIntoView(lid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(lid));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", lid);
		if (!lid.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		lid.clear();
		}
		lid.sendKeys(id);
		}
		catch (StaleElementReferenceException e) {
		}
	}
	

	public void setLearnerName(String lname) {
		WebElement name = driver.findElement(By.xpath("//input[@type='text' and @id='name' and @class='form-control']"));
		if (!name.getAttribute("value").isEmpty()) {
            // Clear the existing value
           
		name.clear();
		}
		name.sendKeys(lname);
	}

	public void setCourse() {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-select required' and @aria-label='Default select example' and @name='course']")));
		select.selectByVisibleText("FSD");
	}

	public void setProject() {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-select required' and @name='project']")));
		select.selectByVisibleText("KKEM");
	}

	public void setBatch() {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-select required' and @aria-label='Default select example' and @name='batch']")));
		select.selectByVisibleText("May_22");
	}

	public void setcourseStatus() {
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-select required' and @name='cstatus']")));
		select.selectByVisibleText("Qualified");
	}
	public void LSubmit()
	{
		WebElement sub= driver.findElement(By.xpath("//button[@class='btn btn-success' and text()='Submit']"));
		sub.click();
	}
	public void popup()
	{
	WebElement popupmsg = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", popupmsg);
	//driver.switchTo().alert().accept();
	}
	public String Verifypopup()
	{
		WebElement popupmsg = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']"));
		String buttonText = popupmsg.getText();
	    return buttonText; 
		
	}
	
	public void Editlearner() throws InterruptedException
	{
		try
		{
	WebElement edit=driver.findElement(By.xpath("(//button[@class='btn btn-success']//ion-icon[@name='create'])[2]"));
	scrollIntoView(edit);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	wait.until(ExpectedConditions.elementToBeClickable(edit));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", edit);
	//edit.click();
		}
		catch (StaleElementReferenceException e) {
		}
	}
	public void Deletelearner()
	{
	WebElement delete=driver.findElement(By.xpath("(//button[@type='button' and contains(@class, 'btn-danger')])[3]"));
	delete.click();
	}
	public void Addbulklearns()
	{
	WebElement bulk=driver.findElement(By.xpath("//button[@class='mb-3 btn btn-success']/ion-icon[@name='cloud-upload']"));
	bulk.click();
	}
	public void Choosefile(String upload) {
WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and @name='file']"));
 fileInput.sendKeys(upload);
	}
	public void Submitcsvfile()
	{
	WebElement submit=driver.findElement(By.xpath("//button[@class='ui grey mini button' and @type='submit']"));
	submit.click();
	}
	public void ReturnedToDashboard() throws InterruptedException
	{
	WebElement dash=driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='Return to Dashboard']"));
	scrollIntoView(dash);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	wait.until(ExpectedConditions.elementToBeClickable(dash));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", dash);
	//dash.click();
	}
	public String DataAdded() throws InterruptedException
	{
	WebElement dash=driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='Return to Dashboard']"));
	Alert alert = driver.switchTo().alert();
     String alertText = alert.getText();
     return alertText;
	}
	public void SaveCsvFile()
	{
	WebElement save=driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']"));
	save.click();
	}
	public void DownloadCsvFile()
	{
	WebElement download=driver.findElement(By.linkText("Click here to download a sample csv file"));
	download.click();
	}
	public void BackToDashboard()
	{
	WebElement dash=driver.findElement(By.xpath("//button[@class='btn btn-warning' and text()='Back to Dashboard']"));
	
	dash.click();
	}
	
	public String Blankcourse()
	{
		String msg= driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger' and text()='Please select a course for the learner']")).getText();
		return msg;
	}
	public String Blankbatch()
	{
		String msg= driver.findElement(By.xpath("//select[@class='form-select required' and @aria-label='Default select example' and @name='batch']")).getText();
		return "May_22\nJun_22\nJul_22\nAug_22\nDec_22\nMar_23";
	}
	public void scrollIntoView(WebElement element) throws InterruptedException {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	

}
	
}

