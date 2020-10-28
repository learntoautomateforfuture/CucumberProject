package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Hooks.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import static org.junit.Assert.*;

import java.util.List;

public class TestSampleDef {
	WebDriver driver = null;

	@Before
	public void beforeScenario(){
		System.out.println("Before Scenario");
		System.out.println("Navigate to the page");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"//Driver//chromedriver.exe");
		driver = new ChromeDriver();
	} 

	@After
	public void afterScenario(){
		System.out.println("After Scenario");
		driver.close();
	}

	@Given("^User navigates to Amazon site$")
	public void user_navigates_to_Amazon_site() throws Throwable {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@When("^Search data is entered$")
	public void search_data_is_entered() throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
	}

	@And("^Click on the search button$")
	public void click_on_the_search_button() throws Throwable {
		driver.findElement(By.xpath("//input[@class='nav-input']")).submit();
	}

	@Then("^Search result is displayed$")
	public void search_result_is_displayed() throws Throwable {
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]")).isDisplayed();	  
	}

	@When("^Search data as \"([^\"]*)\" is entered$")
	public void search_data_is_entered(String data) throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data);
	}	

	@When("^SignIn is clicked$")
	public void clickOnSignIn() throws Throwable {
		driver.findElement(By.id("nav-link-accountList")).click();
	}	

	@Then("^Click on create your amazon account$")
	public void create_your_account() throws Throwable {
		driver.findElement(By.id("createAccountSubmit")).click();
	}

	@And("^Enter the invalid details and continue$")
	public void enter_invalid_details(DataTable table){
		//Initialize data table 
		List<List<String>> data = table.raw();
		driver.findElement(By.id("ap_customer_name")).sendKeys(data.get(1).get(1)); 
		driver.findElement(By.id("ap_phone_number")).sendKeys(data.get(2).get(1)); 
		driver.findElement(By.id("ap_email")).sendKeys(data.get(3).get(1)); 
		driver.findElement(By.id("ap_password")).sendKeys(data.get(4).get(1)); 
		driver.findElement(By.id("continue")).click();	
	}
	
	@Then("^Error message should be displayed$")
	public void error_msg_for_invalid_details() throws Throwable {
		boolean actual = driver.findElement(By.id("auth-error-message-box")).isDisplayed();
		Assert.assertTrue(actual);
	}

}
