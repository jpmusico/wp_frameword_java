package com.wp.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.wp.model.BaseTestSuite;
import com.wp.pages.LoginPage;
import com.wp.pages.admin.DashBoardPage;

public class Playground extends BaseTestSuite{
	
	@Test
	public void testDoLogin(){
		LoginPage login = PageFactory.initElements(super.driver, LoginPage.class);
	}
	
}
