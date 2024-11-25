package testFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testFiles.JobDetailPage;
import testFiles.JobSearchSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert; // Import TestNG Assert class

public class JobSearchSteps {
    
	// Declare WebDriver at the class level
    WebDriver driver;
    JobSearchSteps jobSearchPage;
    JobDetailPage jobDetailPage;
	
    @Before
    public void setUp() {
        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        jobSearchPage = new JobSearchSteps();
        jobDetailPage = new JobDetailPage(driver);
    }
    
    @Given("the user navigates to the LabCorp website")
    public void navigateToLabCorpWebsite() {
        driver.get("https://www.labcorp.com");
    }

    @When("the user clicks on the Careers link")
    public void clickCareersLink() {
    	jobDetailPage.clickCareersLink();
    }

    @When("the user searches for a job titled {string}")
    public void searchForJob(String jobTitle) {
    	jobDetailPage.searchForJob(jobTitle);
    }

    @When("the user selects the first job listing")
    public void selectJobListing() {
    	jobDetailPage.selectFirstJob();
    }

	@Then("the job title should be {string}")
    public void verifyJobTitle(String expectedTitle) {
        String actualTitle = jobDetailPage.getJobTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Actual string does not contain expected text");
    }

    @Then("the job location should be {string}")
    public void verifyJobLocation(String expectedLocation) {
        String actualLocation = jobDetailPage.getJobLocation().trim().substring(8);
        Assert.assertTrue(actualLocation.contains(expectedLocation), "Job location does not match");
    }
    
    @Then("the job ID should be {string}")
    public void verifyJobID(String expectedJobId) {
        String actualJobId = jobDetailPage.isJobIDDisplayed();        
        Assert.assertTrue(actualJobId.contains(expectedJobId), "Job Id does not match");
    }

    @Then("the job description should contain the following texts:")
    public void theJobDescriptionShouldContainTheFollowingTexts(DataTable table) {
        
    	String jd = driver.findElement(By.xpath("//div[contains(@class,'jd-info')]//ul")).getText();
    	System.out.println(jd);
    	List<String> texts = table.asList(String.class);        
        for (String text : texts) {
        	
        	Assert.assertTrue(jd.contains(text));
        }
    }

    @When("the user clicks Apply Now")
    public void clickApplyNow() {
        jobDetailPage.clickApplyNow();
    }

   
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close all browser windows and terminate the WebDriver session
        }
    }
}
