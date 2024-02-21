package kkem.com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import kkem.com.pages.AdminLearner;
import kkem.com.pages.AdminPlacement;
import kkem.com.pages.AdminUsers;
import kkem.com.pages.AutomationConstant;
import kkem.com.pages.Login;
import kkem.com.pages.Logout;

public class TestClass extends TestBaseClass {
	Login login = null;
	AdminUsers admin = null;
	AdminLearner adminlear = null;
	AdminPlacement adminplace = null;
	Logout logout = null;

	@Test(priority = 0)
	public void Loginpage() throws InterruptedException {
		login = new Login(driver);
		String actualResult = login.Logo();
		Assert.assertEquals(actualResult, AutomationConstant.expResult);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();

	}

	 @Test(priority = 1)
	public void UserForm() throws InterruptedException {
		admin = new AdminUsers(driver);

		admin.Adminadduser();

		admin.setName("keerthana");
		admin.setEmail("sravyalak123@gmail.com");
		admin.setUser("sravyalakshmanan");
		admin.setPass("password123456@");
		admin.setRoll();
		admin.Submit();
		admin.popup1();
		

	}

	 @Test(priority = 2)

	public void VerifyUpdate() {

		// login = new Login(driver);
		// login.setUsername("admin");
		// login.setpassword("admin@123");
		// login.ClickLogin();
		admin = new AdminUsers(driver);
		admin.Update();

		admin.setEmail("manjimak123@gmail.com");
		admin.Submit();

		
		String actualResult1 = admin.UpdateEmail("manjimak123@gmail.com");
		String expectedEmail = AutomationConstant.updateemail;

		// Use assertEquals for comparison
		Assert.assertEquals(expectedEmail, actualResult1);
	}

	@Test(priority = 3)
	public void VerifyDelete() throws InterruptedException {
		admin = new AdminUsers(driver);

		admin.Delete();
		
		}

	 @Test(priority = 4)
	public void learns() throws InterruptedException {
		adminlear = new AdminLearner(driver);
		
		 
		adminlear.Learnslink();
		adminlear.AddLearns();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		adminlear.setlearnerid("45");
		adminlear.setLearnerName("geetha");
		adminlear.setCourse();
		adminlear.setProject();
		adminlear.setBatch();
		adminlear.setcourseStatus();
		adminlear.LSubmit();
		adminlear.popup();
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();

	}

	 @Test(priority = 5)
	public void VerifyEdit() throws InterruptedException {
		adminlear = new AdminLearner(driver);
		login = new Login(driver);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();
		adminlear.Learnslink();
		adminlear.Editlearner();
		adminlear.setlearnerid("346");
		adminlear.setLearnerName("geethanandini");
		adminlear.LSubmit();


	}

	 @Test(priority = 6)
	public void VerifyDeletelearner() throws InterruptedException {
		adminlear = new AdminLearner(driver);
		adminlear.Deletelearner();

		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();
	}

	 @Test(priority = 7)
	public void AdminAddBulkLearns() throws InterruptedException {
		adminlear = new AdminLearner(driver);
		login = new Login(driver);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();
		adminlear.Learnslink();
		adminlear.Addbulklearns();
		adminlear.Choosefile("C:\\Users\\sravy\\OneDrive\\Desktop\\learner.csv");
		adminlear.Submitcsvfile();
		adminlear.ReturnedToDashboard();
		String actualResult = adminlear.DataAdded();
		Assert.assertEquals(actualResult, AutomationConstant.msg);

		adminlear.SaveCsvFile();
		adminlear.Addbulklearns();
		adminlear.DownloadCsvFile();
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();

	}

	 @Test(priority = 8)
	public void PlacementUpdate() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();
		adminplace = new AdminPlacement(driver);
		adminplace.Placementlink();
		adminplace.PlacementUpdate();
		adminplace.setPlacement();
		adminplace.PlacementSubmit();

		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();

	}

	 @Test(priority = 9)
	public void TrainerLogin() throws InterruptedException {
		login = new Login(driver);

		login.setUsername("trainer");
		login.setpassword("trainer@123");
		login.ClickLogin();
		adminlear = new AdminLearner(driver);
		adminlear.AddLearns();
		adminlear.setlearnerid("45");
		adminlear.setLearnerName("geetha");
		adminlear.setCourse();
		adminlear.setProject();
		adminlear.setBatch();
		adminlear.setcourseStatus();
		adminlear.LSubmit();
		adminlear.popup();
		String actualResult = adminlear.Verifypopup();
		Assert.assertEquals(actualResult, AutomationConstant.popup);

		adminlear.Deletelearner();

		// logout = new Logout(driver);
		// logout.Logoutpage();
		// logout.LogoutClick();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	 @Test(priority = 10)
	public void TrainerEdit() throws InterruptedException {
		// login = new Login(driver);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// login.setUsername("trainer");
		// login.setpassword("trainer@123");
		// login.ClickLogin();
		adminlear = new AdminLearner(driver);
		adminlear.Learnslink();
		adminlear.Editlearner();
		adminlear.setlearnerid("45");
		adminlear.LSubmit();

		// logout = new Logout(driver);
		// logout.Logoutpage();
		// logout.LogoutClick();
	}

	@Test(priority = 11)
	public void TrainerAddBulkLearns() throws InterruptedException {
		// login = new Login(driver);

		/// login.setUsername("trainer");
		// login.setpassword("trainer@123");
		// login.ClickLogin();
		adminlear = new AdminLearner(driver);
		adminlear.Addbulklearns();
		adminlear.Choosefile("C:\\Users\\sravy\\OneDrive\\Desktop\\learner.csv");
		adminlear.Submitcsvfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		adminlear.ReturnedToDashboard();

		adminlear.SaveCsvFile();
		adminlear.Addbulklearns();
		adminlear.DownloadCsvFile();
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();
	}

	 @Test(priority=12)
	public void Officerlogin() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("pofficer");
		login.setpassword("pofficer@123");
		login.ClickLogin();
		adminplace = new AdminPlacement(driver);
		adminplace.PlacementUpdate();
		adminplace.setPlacement();
		adminplace.PlacementSubmit();
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();
	}

	@Test(priority=13)
	public void Trainerblankbatch() throws InterruptedException {
		login = new Login(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@class='form-control' and @name='username']")));

		WebElement usernameField = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@class='form-control' and @name='username']")));
		login.setUsername("trainer");
		login.setpassword("trainer@123");
		login.ClickLogin();
		adminlear = new AdminLearner(driver);
		adminlear.Learnslink();
		adminlear.AddLearns();
		adminlear.setlearnerid("45");
		adminlear.setLearnerName("geetha");
		adminlear.setCourse();
		adminlear.setProject();
		adminlear.setcourseStatus();
		adminlear.LSubmit();
		String actualResult = adminlear.Blankbatch();
		Assert.assertEquals(actualResult, AutomationConstant.expresult4);
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();
	}

	 @Test(priority = 14)
	public void TrainerInvalidLogin() throws InterruptedException {
		login = new Login(driver);

		login.setUsername("trainer");
		login.setpassword("trainer@1234");
		login.ClickLogin();
		String actualResult = login.LoginFailed();
		Assert.assertEquals(actualResult, AutomationConstant.log);
	}

	 @Test(priority=15)
	public void AdminInvalidLogin() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("adminadmin");
		login.setpassword("admin@123");
		login.ClickLogin();
	}

	@Test(priority=16)
	public void UsernameBlank() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();
		admin = new AdminUsers(driver);
		admin.Adminadduser();
		admin.setName("keerthana");
		admin.setEmail("sravyalak123@gmail.com");
		admin.setPass("password123456@");
		admin.setRoll();
		admin.Submit();
		String actualResult = admin.Blankusername();
		Assert.assertEquals(actualResult, AutomationConstant.expResult1);

	}

	@Test(priority=17)
	public void BlankCourse() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("Anju1");
		login.setpassword("Password12345@");
		login.ClickLogin();
		adminlear = new AdminLearner(driver);
		adminlear.Learnslink();
		adminlear.AddLearns();
		adminlear.setlearnerid("45");
		adminlear.setLearnerName("geetha");
		adminlear.setProject();
		adminlear.setBatch();
		adminlear.setcourseStatus();
		adminlear.LSubmit();
		String actualResult = adminlear.Blankcourse();
		Assert.assertEquals(actualResult, AutomationConstant.expResult3);
		logout = new Logout(driver);
		logout.Logoutpage();
		logout.LogoutClick();
    }
    @Test(priority = 18)
	public void OfficerInvalidLogin() throws InterruptedException {
		login = new Login(driver);
		login.setUsername("officer");
		login.setpassword("officer@1234");
		login.ClickLogin();
		String actualResult = login.LoginFailed();
		Assert.assertEquals(actualResult, AutomationConstant.log);
	}

}
