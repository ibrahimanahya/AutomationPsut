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

public class SignupSpecial {
	
	WebDriver driver = new EdgeDriver();
	
	String TheWebSite = "https://automationexercise.com/";
	
	String TheSinnupPage= "https://automationexercise.com/signup";
	
	String TheLoginPage= "https://automationexercise.com/login";
	
    Random rand = new Random();
	
	String publicEmail;
	
	

   @BeforeTest
public void MySetup() {
	   
	   driver.get(TheWebSite);
	   
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
   }

   public void SignUp() {
	   
	  String [] UserNames = {"AHMAD","HAMZA","IBRAHIM","SALEH","MOHAMMED"};// STATIC ARRAY 
	   
	   int randomUserIndex = rand.nextInt(UserNames.length);
	   
	   int myRandomNumperForTheEmail = rand.nextInt(5469820);
	   
	   String TheEmailAddress = UserNames[randomUserIndex]+myRandomNumperForTheEmail+"@gmail.com";
	   
	   publicEmail= TheEmailAddress;
	   
	   driver.navigate().to(TheSinnupPage);
	   
   WebElement NameSignup = driver.findElement(By.cssSelector("input[placeholder='Name']"));
	   
	   WebElement EmailAddressSignup = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
	   
	   WebElement SignUpButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
	   
	   NameSignup.sendKeys("IBRAHIM");
	   
	   EmailAddressSignup.sendKeys(TheEmailAddress);
	   
	   SignUpButton.click();
	   
   }
	   
	 public void Login() {
		 
		 driver.navigate().to(TheLoginPage);
		 
		 driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(publicEmail);
		 
		 
		 
		 
	 }
	 
    @Test
    
    public void SignUpLoginPattern() {
        // 1) SignUp
        SignUp();

        // 2) Login
        Login();

        // 3) SignUp
        SignUp();

        // 4) Login
        Login();
        
        //5) SignUp
        SignUp();
        
        //6) Login
        Login();
    }

	 
   @AfterTest
  
  public void AfterFinishingTheTest(){
	   
   
   
   
   
   
   
   }
   }