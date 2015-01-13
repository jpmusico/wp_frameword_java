package com.wp.tests.ui.admin;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import com.wp.model.BaseTestSuite;
import com.wp.model.User;
import com.wp.pages.LoginPage;
import com.wp.pages.admin.DashBoardPage;
import com.wp.pages.admin.UsersPage;

public class Users extends BaseTestSuite{

	@Test
	public void test_create_new_blog_user(){
		//Prepare
		User user=new User();
		user.setUserName("UserName");
		user.setEmail("email@email.com");
		user.setPassword("admin@123");

		//Act
		LoginPage login = PageFactory.initElements(super.driver, LoginPage.class);
		DashBoardPage dashboard = (DashBoardPage) login.doLogin("test", "test");
		UsersPage users = dashboard.openUsersPage();
		users.clickNewUserAddButton();	
		users.fillUserRequiredData(user, true);
		users.submitNewUserForm();
		
		//Verify
		Assert.assertTrue(users.verifyUserOnTable(user));
	}
	
}
