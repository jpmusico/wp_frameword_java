package com.wp.tests.ui.admin;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.wp.model.BaseTestSuite;
import com.wp.pages.LoginPage;
import com.wp.pages.admin.DashBoardPage;

public class Login extends BaseTestSuite{

	@Test
	public void test_login_valid_user(){
		//Prepare
		LoginPage login = PageFactory.initElements(super.driver, LoginPage.class);
		
		//Act
		DashBoardPage dashboard = (DashBoardPage) login.doLogin("test", "test");
		
		//Verify
		Assert.assertTrue(dashboard.verifyLoggedUser("test"));
	}
	
	@Test
	public void test_login_invalid_user(){
		//Prepare
		LoginPage login = PageFactory.initElements(super.driver, LoginPage.class);
		
		//Act
		login.doLogin("test123", "test");
		
		//Verify
		Assert.assertTrue(login.verifyError("Invalid username."));
	}
	
	@Test
	public void test_login_invalid_password(){
		//Prepare
		LoginPage login = PageFactory.initElements(super.driver, LoginPage.class);
		
		//Act
		login.doLogin("test", "test123");
		
		//Verify
		Assert.assertTrue(login.verifyError("The password you entered for the username test is incorrect."));
	}
	
}
