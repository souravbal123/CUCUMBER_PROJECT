package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_SD {
	public WebDriver driver;

	@Given("User is logged in")
	public void user_is_logged_in() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("souravbal");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Sourav@123");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();

	}

	@When("User click on logout button")
	public void user_click_on_logout_button() {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
	}

	@Then("User successfully logged out")
	public void user_successfully_logged_out() {
		String act_title = driver.getCurrentUrl();
		String exp_title = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
		Assert.assertEquals(exp_title, act_title);
		driver.close();
	}
}
