package com.wp.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wp.model.BasePageObject;
import com.wp.model.User;

public class UsersPage extends BasePageObject {

	@FindBy(xpath = ".//h2[contains(.,'Users')]")
	WebElement verifyPageElement;

	// href
	@FindBy(xpath = ".//h2[contains(.,'Users')]/a[.='Add New']")
	WebElement newUserButton;
	
	//tbody
	@FindBy(xpath = ".//tbody[@id='the-list']")
	WebElement usersTable;

	// input
	@FindBy(xpath = ".//input[@id='user_login']")
	WebElement user_login;

	@FindBy(xpath = ".//input[@id='email']")
	WebElement email;

	@FindBy(xpath = ".//input[@id='pass1']")
	WebElement password;

	@FindBy(xpath = ".//input[@id='pass2']")
	WebElement confirm_password;
	
	@FindBy(xpath = ".//input[@id='createusersub']")
	WebElement btnCreateUser;

	public UsersPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(this.driver, this);
		if (!verifyPageElement.isDisplayed()) {
			throw new IllegalStateException("This is not the correct page");
		}
	}

	public void clickNewUserAddButton() {
		new WebDriverWait(driver, 15).until(ExpectedConditions
				.visibilityOf(newUserButton));
		newUserButton.click();
	}

	public void fillUserRequiredData(User user, Boolean correct_password) {
		new WebDriverWait(driver, 15).until(ExpectedConditions
				.visibilityOf(user_login));
		user_login.sendKeys(user.getUserName());
		email.sendKeys(user.getEmail());
		password.sendKeys(user.getPassword());
		if (correct_password) {
			confirm_password.sendKeys(user.getPassword());
		}
		else confirm_password.sendKeys(user.getPassword() + "123");
	}
	
	public void submitNewUserForm(){
		btnCreateUser.click();
	}
	
	public Boolean verifyUserOnTable(User user){
		if(usersTable.findElements(By.partialLinkText(user.getUserName())).size()>0){
			return true;
		}
		else return false;
	}

}
