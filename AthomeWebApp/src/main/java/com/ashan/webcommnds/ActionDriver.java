package com.ashan.webcommnds;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;


import com.ashan.config.StartBrowser;

public class ActionDriver 
{
	
	WebDriver driver;
	
	public ActionDriver() 
	{
		
		driver = StartBrowser.driver ;
		
	}
	
	public void navigateToApp(String url) 
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully navigate to : " + url);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to navigate to : " + url);
		}
		 
		
	}
	
	public void enterTXT(By locator, String word, String elmentname) throws Exception 
	{
		try {
			driver.findElement(locator).sendKeys(word);
			StartBrowser.childTest.pass("Successfully typed on: " + elmentname + " with " + word);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to typed on: " + elmentname + " with " + word , MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw(e);
		}
		 
		
	}
	
	public void clickButtn(By locator,String elmentname) throws Exception 
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully clicked : " + elmentname);
			
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to click : " + elmentname , MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw(e);
		}
		 
		
	}
	
	public boolean isDisplayVerifiction(By locator,String elmentname) throws Exception 
	{
		return driver.findElement(locator).isDisplayed();
		 
		
	}
	
	public String screenShot() 
	{
		return ((TakesScreenshot) driver) .getScreenshotAs(OutputType.BASE64);
	}
	
	

}
 