package com.ashan.reuseble;

import org.openqa.selenium.WebDriver;

import com.ashan.config.StartBrowser;
import com.ashan.objectpropertis.HomePage;
import com.ashan.objectpropertis.LoginPage;
import com.ashan.webcommnds.ActionDriver;



public class BusinessFunctions {
	
	WebDriver driver;
	ActionDriver aDriver;
	
	public  BusinessFunctions() 
	{
		
		driver = StartBrowser.driver;
		aDriver = new ActionDriver();
		
	}
	
	public void login() throws Exception 
	{
		  StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to App");
		
		  aDriver.navigateToApp("https://www.athome.com/login/");
		  
		  aDriver.enterTXT(LoginPage.txtUserName,"userneme","UserName");
		  
		  aDriver.enterTXT(LoginPage.txtPasswrd,"Sample@1234","Passwrd");
		  
		  aDriver.clickButtn(LoginPage.btnLogin,"Loginbtn");
		
		
	}
	
	public void homeV() throws Exception 
	{
		  StartBrowser.childTest = StartBrowser.parentTest.createNode("Home Verification Starts");
		
		  
	}
	
	public void logout() throws Exception 
	{
		  StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from App");
		
		  aDriver.clickButtn(HomePage.Mousemove,"Mouse point");
		  
		  aDriver.clickButtn(HomePage.Logoutlink,"Logout Link");
		
		
	}

}
