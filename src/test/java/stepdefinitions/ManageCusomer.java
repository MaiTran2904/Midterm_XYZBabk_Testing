package stepdefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageCusomer {
	WebDriver driver = null;

	@Given("user is on manager page")
	public void user_is_on_manager_page() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver","C:\\Users\\Mai Mai\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
	}
	
	//Verify manage customer page
	@Given("verify manager page")
	public void verify_manager_page() throws InterruptedException {
		String manageCusPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		String manageCusPageTitle = driver.getTitle();
		Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
		Thread.sleep(1000);
	}

	//Add a new customer
	@When("user clicks on Add Customer button")
	public void user_clicks_on_add_customer_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(1000);
	}

	@When("user enters <firstname> and <lastname> and <postcode>")
	public void user_enters_firstname_and_lastname_and_postcode() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Mai");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Tran");
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("Mai@123");
		Thread.sleep(1000);
	}
	
	@When("user enters <firstname>")
	public void user_enters_firstname() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Mai");
		Thread.sleep(1000);
	}
	
	@When("user enters <firstname> and <lastname>")
	public void user_enters_firstname_and_lastname() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Mai");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Tran");
		Thread.sleep(1000);
	}
	
	@And("user clicks Add Customer button")
	public void user_clicks_add_customer_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}
	
	@And("user accepts alert")
	public void user_accepts_alert() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	//Open an new Account
	@When("user clicks Open Account button")
	public void user_clicks_open_account_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(1000);
	}
	
	@When("user selects <account> and <currency>")
	public void select_account_and_currency() throws InterruptedException {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Harry Potter')]")).click();
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}
	@When("user selects <currency>")
	public void user_selects_currency() throws InterruptedException {
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}
	
	@And("user clicks Process button")
	public void user_clicks_process_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(1000);
	}
	
	//Search a Customer
	@When("user clicks Customer button")
	public void user_clicks_customer_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
	}
	
	@When("user searches an existing customer")
	public void user_searches_an_existing_customer() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Harry");
		Thread.sleep(1000);
	}

	@When("user searches customer name does not exist")
	public void user_searches_customer_name_does_not_exist() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Mai Mai");
		Thread.sleep(1000);
	}

	@Then("the message is displayed")
	public void the_message_is_displayed() {
		driver.quit();
	    System.out.println("Successfully excution");
	}

}
