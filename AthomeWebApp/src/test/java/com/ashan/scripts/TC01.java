package com.ashan.scripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ashan.config.StartBrowser;
import com.ashan.objectpropertis.HomePage;
import com.ashan.reuseble.BusinessFunctions;
import com.ashan.webcommnds.ActionDriver;
import com.aventstack.extentreports.MediaEntityBuilder;


@Test
public class TC01 extends StartBrowser {
	
	public void testLogin() throws Exception {
		BusinessFunctions bsnsFction = new BusinessFunctions();
		bsnsFction.login();
	}
	
	public void homeVerify() throws Exception {
		
		BusinessFunctions bsnsFction = new BusinessFunctions();
		bsnsFction.homeV();
		
		
		ActionDriver actiondv = new ActionDriver();
		try {
			
		boolean Result = actiondv.isDisplayVerifiction(HomePage.WelcomeAccount,"My Account" );
		
		
			
			Assert.assertEquals(Result, true);
			StartBrowser.childTest.pass("Successfully verified");
			
		} catch (Exception e) {
			
			StartBrowser.childTest.fail("Unable to veryfy " ,MediaEntityBuilder.createScreenCaptureFromBase64String(actiondv.screenShot()).build());
			StartBrowser.childTest.info(e);
			throw(e);
		}
		
	}
	
	public void testLogout() throws Exception {
			
			BusinessFunctions bsnsFction = new BusinessFunctions();
			
			bsnsFction.logout();
	}
		
}
