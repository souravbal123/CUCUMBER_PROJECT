package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsOverview_SD {
	public WebDriver driver;

	@Given("User is logged in with correct userid and password")
	public void user_is_logged_in_with_correct_userid_and_password() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("souravbal");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Sourav@123");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}

	@When("User click on acconts overview button")
	public void user_click_on_acconts_overview_button() {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a")).click();
	}

	@Then("Page should open")
	public void page_should_open() {
		String act_title = driver.getCurrentUrl();
		String exp_title = "https://parabank.parasoft.com/parabank/overview.htm";
		Assert.assertEquals(exp_title, act_title);
		driver.close();
	}
}
