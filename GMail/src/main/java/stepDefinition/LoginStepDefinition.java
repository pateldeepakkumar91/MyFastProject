package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	
	WebDriver driver;
   
	@Given("^navigate to gmail page$")
    public void navigate() throws Exception{
	
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
	
	ChromeOptions options =new ChromeOptions();
	//options.addArguments("--disable-notifications");
	
	WebDriver driver = new ChromeDriver(options);
	
	
	driver.get("http://www.google.com");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	Thread.sleep(5000);
	}
	@When ("^user logged in using username as \"(.*)\" and password as \"(.*)\"$")
	public void login(String username,String password){
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='signIn']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Then("^home page should be displayed$")
	public void verifySuccessful(){
		String expectedText="Gmail";
      String actualText=         driver.findElement(By.xpath("//*[@id='gbq1']/div/a/span")).getText();
	   Assert.assertTrue("Login not successful",expectedText.equals(actualText));
	      }


}