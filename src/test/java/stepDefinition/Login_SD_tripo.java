package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login_SD_tripo {
	public WebDriver driver;

	@Given("Login page opened")
	public void login_page_opened() {
		// System.setProperty("webdriver.chrome.driver",
		// "./Driver/chromedriver109.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tripodeal.com/portal/login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@When("user enters valid email")
	public void user_enters_valid_email() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hibibhu123@gmail.com");
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("India@123");
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/form/div[4]/button")).click();
	}

	@Then("user will be logged in successfully")
	public void user_will_be_logged_in_successfully() {
		String act_str = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[2]/h4"))
				.getText();
		String exp_str = "hibibhu123@gmail.com";
		Assert.assertEquals(act_str, exp_str);
		driver.close();
	}

	@When("user enters invalid email")
	public void user_enters_invalid_email() {
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hibibhu1234@gmail.com");

	}

	@When("user enters invalid password")
	public void user_enters_invalid_password() {
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("india@123");

	}

	@Then("invalid credientials error message will be displayed")
	public void invalid_credientials_error_message_will_be_displayed() {
		String act_error_text = driver.findElement(By.xpath("//li[contains(text(),'Invalid credentials.')]")).getText();
		String exp_error_text = "Invalid credentials.";
		Assert.assertEquals(act_error_text, exp_error_text);
		driver.close();
	}

}
