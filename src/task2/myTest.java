package task2;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTest {
	
	WebDriver driver = new EdgeDriver();
	String ThewebSite = "https://automationexercise.com/";
	String TheSinnupPage= "https://automationexercise.com/signup";
	String LoginPage ="https://automationexercise.com/login";
	String Password = "280718$";
	Random rand = new Random();
	String [] UserNames = {"IBRAHIM","AHAMD","HAMZA","SALEH"};
	int randomUserIndex= rand.nextInt(UserNames.length);
	int MyRamdomNumberForTheEmail= rand.nextInt(2503652);
	String TheEmailAddres=(UserNames[randomUserIndex]+MyRamdomNumberForTheEmail+"@gamil.com");
	String publicEmail;
	
	@BeforeTest
	
	public void Mytest() {
		
		driver.get(ThewebSite);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	
	  public void SignUp() throws InterruptedException {
		   
		publicEmail= TheEmailAddres;
	
		   driver.navigate().to(TheSinnupPage);
	
		   WebElement signupNameField   = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		   WebElement signupEmailField  = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		   WebElement signupButton      = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
		   signupNameField.sendKeys("IBRAHIM");
		   signupEmailField.sendKeys(TheEmailAddres);
		   signupButton.click();
		   driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		   driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		   
	}	   
	
	@Test(priority = 2)
	  public void SelectInput() throws InterruptedException {	 

		WebElement RandomDay = driver.findElement(By.id("days"));
		int TotalDayIndex = RandomDay.findElements(By.tagName("option")).size();
		Select daySelect   = new Select(RandomDay);
		int RandomDayIndex = rand.nextInt(1,TotalDayIndex);
		daySelect.selectByIndex(RandomDayIndex);
	    Thread.sleep(2000);
		WebElement RandomMonth = driver.findElement(By.id("months"));
		int TotalMonthIndex = RandomMonth.findElements(By.tagName("option")).size();
		Select monthSelect = new Select(RandomMonth);
		int RandomMonthIndex=rand.nextInt(1,TotalMonthIndex);
		monthSelect.selectByIndex(RandomMonthIndex);
		  Thread.sleep(2000);
		WebElement RandomYear = driver.findElement(By.id("years"));
		int TotalYearIndex = RandomYear.findElements(By.tagName("option")).size();
		Select yearSelect  = new Select(RandomYear);
		int RandomYearIndex=rand.nextInt(1,TotalYearIndex);
		yearSelect.selectByIndex(RandomYearIndex);
	}
	
	@Test(priority = 3)
	  public void Personalinformation() {
		
			WebElement firstNameField    = driver.findElement(By.id("first_name"));
			WebElement lastNameField     = driver.findElement(By.id("last_name"));
			WebElement addressField      = driver.findElement(By.id("address1"));
			WebElement stateField        = driver.findElement(By.id("state"));
			WebElement cityField         = driver.findElement(By.id("city"));
			WebElement zipcodeField      = driver.findElement(By.id("zipcode"));
			WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));

			firstNameField.sendKeys("IBRAHIM");
			lastNameField.sendKeys("NAHYA");
			addressField.sendKeys("45 King Abdullah Street");
			stateField.sendKeys("Amman");
			cityField.sendKeys("Amman");
			zipcodeField.sendKeys("11181");
			mobileNumberField.sendKeys("+962790123456");			
		}
	
	@Test(priority = 4)
	  public void SelectCountry() throws InterruptedException {	
   
		String[] countries = {"Jordan", "United States", "Canada"};
		Select countrySelect = new Select(driver.findElement(By.id("country")));
		countrySelect.selectByVisibleText(
		        countries[rand.nextInt(countries.length)]);
	
		WebElement createAccountButton =
		        driver.findElement(By.cssSelector(".btn.btn-default"));
		createAccountButton.click();
		
		Thread.sleep(3000);
		WebElement continueButton =
		        driver.findElement(By.cssSelector("a.btn.btn-primary"));

		continueButton.click();
		 
	}
	
	@Test(priority = 5)
	  public void Logout() {
		
		driver.navigate().to("https://automationexercise.com/logout");
	}
	
	@Test(priority = 6)
	public void Login() {
		
		WebElement loginEmailField =
		        driver.findElement(By.xpath("//input[@data-qa='login-email']"));

		WebElement loginPasswordField =
		        driver.findElement(By.xpath("//input[@placeholder='Password']"));

		WebElement loginButton =
		        driver.findElement(By.xpath("//button[normalize-space()='Login']"));

		loginEmailField.sendKeys(TheEmailAddres);
		loginPasswordField.sendKeys(Password);
		loginButton.click();
	}
	
	@Test(priority = 7)
	
	public void DeleteAccount() throws InterruptedException {
		
		driver.navigate().to("https://automationexercise.com/delete_account");
		Thread.sleep(2000);
		WebElement continueButton =
		        driver.findElement(By.xpath("//a[@class=\"btn btn-primary\"]"));
		continueButton.click();
	}

	@AfterTest
	
	public void AfterFinishingTest() {
	
	}
}
