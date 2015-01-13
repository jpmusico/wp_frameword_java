package com.wp.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;
import com.wp.model.BasePageObject;

public class DashBoardPage extends BasePageObject{

	@FindBy(xpath="//h2[.='Dashboard']")
	WebElement verifyPageElement;
	
	@FindBy(xpath=".//a[@title='My Account']")
	WebElement loggedUser;
	
	//Right menu items
	@FindBy(xpath=".//*[@id='menu-users']/a/div[2]")
	WebElement users;
	
	public DashBoardPage(WebDriver driver){
		super.driver=driver;
		PageFactory.initElements(this.driver, this);
		if (!verifyPageElement.isDisplayed()){
			throw new IllegalStateException("This is not the correct page");
		}
	}
	
	public UsersPage openUsersPage(){
		users.click();
		return new UsersPage(driver);
	}

	public boolean verifyLoggedUser(String username) {
		return loggedUser.getText().contains(username);
	}

}
