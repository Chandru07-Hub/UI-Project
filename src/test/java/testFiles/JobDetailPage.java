package testFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JobDetailPage {

	
    WebDriver driver;
    Actions act ; 
    
    public JobDetailPage(WebDriver driver) {
        this.driver = driver;
        act = new Actions(driver);
    }
    
    
	public void clickCareersLink() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//a[text()='Careers' and @target='_self']")).click();
	}
	
	public void searchForJob(String jobTitle2) {
		
		driver.findElement(By.id("typehead")).sendKeys(jobTitle2);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void selectFirstJob() {
		
		driver.findElement(By.xpath("(//ul//li[@class=\"jobs-list-item\"]//a)[1]")).click();
		
	}

    // Get the job title
    public String getJobTitle() {
        WebElement jobTitleElement = driver.findElement(By.tagName("h1"));
        return jobTitleElement.getText();
    }

    // Get the job location
    public String getJobLocation() {
        WebElement jobLocationElement = driver.findElement(By.xpath("(//section//span[contains(@class,'job-location')])[1]"));
        return jobLocationElement.getText();
    }

    // Get the job ID
    public String isJobIDDisplayed() {
        WebElement jobIDElement = driver.findElement(By.xpath("//span[text()=2430741]"));
        return jobIDElement.getText();
    }

    // Click on the Apply Now button
    public void clickApplyNow() {
        WebElement applyNowButtonElement = driver.findElement(By.xpath("//a[contains(@aria-label,'Apply Now')]"));
        applyNowButtonElement.click();
    }










}
