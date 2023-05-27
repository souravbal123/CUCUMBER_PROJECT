package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_SD {
	public WebDriver driver;
	@Given("Login page is opened")
	public void login_page_is_opened() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		 driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
	    
	   
	}
	@When("I enter valid username")
	public void i_enter_valid_username() {
	driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("souravbal");
	}
	@When("I enter valid password")
	public void i_enter_valid_password() {
	    driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Sourav@123");
	}
	@When("I click on signin button")
	public void i_click_on_signin_button() {
	    driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}
	@Then("Login should be successful")
	public void login_should_be_successful() {
		String act_title=driver.getCurrentUrl();
		String exp_title="https://parabank.parasoft.com/parabank/overview.htm";
		Assert.assertEquals(exp_title, act_title);
		driver.close();
	}
}
