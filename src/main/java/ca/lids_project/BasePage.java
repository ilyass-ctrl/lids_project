package ca.lids_project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	public boolean verifyText(WebElement elm, String expextedText) {
		if(elm.getText().equalsIgnoreCase(expextedText))
			return true;
		return false;
	}
	
	public void waitForVisibility(WebElement elm) {
		wait.until(ExpectedConditions.visibilityOf(elm));
	}
	
	public void waitTillElemIsVisible(String selector) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selector)));
	}
	
	abstract public String getPageTitle();
}
