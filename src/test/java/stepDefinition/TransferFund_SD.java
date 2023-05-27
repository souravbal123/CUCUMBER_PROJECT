package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferFund_SD {
	WebDriver driver;

	@Given("User is logged in with correct credentials")
	public void user_is_logged_in_with_correct_credentials() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver109.exe");
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")).sendKeys("souravbal");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")).sendKeys("Sourav@123");

		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	}

	@When("User clicked on transfer fund button")
	public void user_clicked_on_transfer_fund_button() {
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a")).click();
	}

	@When("He puts the amount to transfer")
	public void he_puts_the_amount_to_transfer() {
		driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("500");
	}

	@When("click on transfer button")
	public void click_on_transfer_button() {
		driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")).click();
	}

	@Then("User able to transfer the desired amount")
	public void user_able_to_transfer_the_desired_amount() {
		String act_str = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]")).getText();
		String exp_str = "$500.00 has been transferred from account #18894 to account #18894";
		Assert.assertEquals(act_str, exp_str);
		driver.close();
	}
}
