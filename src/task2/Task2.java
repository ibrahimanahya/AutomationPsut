package task2;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
	
	WebDriver driver = new EdgeDriver();
	
	String TheWebSite = "https://automationexercise.com/";
	
	String TheLoginPage= "https://automationexercise.com/login";
	
	Random rand = new Random();
	
	int myRandomNumperForTheEmail = rand.nextInt(5469820);
	
	String TheEmailAddress = "ibrahim"+myRandomNumperForTheEmail+"@gmail.com";
	
	String Password = "Selenium@2026";


   @BeforeTest
public void MySetup() {
	   
	   driver.get(TheWebSite);
	   
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   
	   
   }
   
   @Test(priority=1)

   public void SignUp() {
	   
	   driver.navigate().to(TheLoginPage);
	   
	   WebElement NameInputField = driver.findElement(By.cssSelector("input[placeholder='Name']"));
	   
	   WebElement EmailAddressInputField = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
	   
	   WebElement SignUpButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
	   
	   NameInputField.sendKeys("ibrahim");
	   
	   EmailAddressInputField.sendKeys(TheEmailAddress);
	   
	   SignUpButton.click();
	   
	   WebElement Gender= driver.findElement(By.id("id_gender1"));
	  
	   Gender.click();
	   WebElement passwordField      = driver.findElement(By.id("password"));
	   WebElement daysDropdown       = driver.findElement(By.id("days"));
	   WebElement monthsDropdown     = driver.findElement(By.id("months"));
	   WebElement yearsDropdown      = driver.findElement(By.id("years"));
	   WebElement firstNameField     = driver.findElement(By.id("first_name"));
	   WebElement lastNameField      = driver.findElement(By.id("last_name"));
	   WebElement addressField       = driver.findElement(By.id("address1"));
	   WebElement countryDropdown    = driver.findElement(By.id("country"));
	   WebElement stateField         = driver.findElement(By.id("state"));
	   WebElement cityField          = driver.findElement(By.id("city"));
	   WebElement zipcodeField       = driver.findElement(By.id("zipcode"));
	   WebElement mobileNumberField  = driver.findElement(By.id("mobile_number"));
	   
	   passwordField.sendKeys(Password);
	   daysDropdown.sendKeys("17");
	   monthsDropdown.sendKeys("July");
	   yearsDropdown.sendKeys("1996");
	   firstNameField.sendKeys("ibrahim");
	   lastNameField.sendKeys("nahya");
	   addressField.sendKeys("92 Lakeview Street");
	   countryDropdown.sendKeys("Canada");
	   stateField.sendKeys("Ontario");
	   cityField.sendKeys("Toronto");
	   zipcodeField.sendKeys("M5H 2N2");
	   mobileNumberField.sendKeys("+1 416 945 2381");


	   
	   WebElement CreateAccountButton = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
	   
	   CreateAccountButton.click();
	   
	   WebElement ContinueButtone = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
	   
	   ContinueButtone.click();
	   
   }

   @Test(priority=2)
   
   public void Logout() {
	   
	   driver.navigate().to("https://automationexercise.com/logout");
	   
   }
		
   @Test(priority=3)
   
    public void Login() {
	   
	   WebElement loginEmailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	   
	   WebElement loginPasswordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	   
	   WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	   
	   loginEmailField.sendKeys(TheEmailAddress);
	   
	   loginPasswordField.sendKeys(Password);

	   loginButton.click();
   }
   
	@Test(priority=4)
	
	public void DeleteAccount() {
		
		driver.navigate().to("https://automationexercise.com/delete_account");
		
	WebElement Continue =	driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]"));
	
	Continue.click();
	}
   
   
   @AfterTest
  
  public void AfterFinishingTheTest(){
	   
   
   
   
   
   
   
   }
   }