package com.wp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wp.model.BasePageObject;
import com.wp.pages.admin.DashBoardPage;

public class LoginPage extends BasePageObject {

	// INPUT
	@FindBy(xpath = ".//input[@id='user_login']")
	private WebElement txtUsername;

	@FindBy(xpath = ".//input[@id='user_pass']")
	private WebElement txtPassword;

	@FindBy(xpath = ".//input[@id='wp-submit']")
	private WebElement btnLogin;

	// DIV
	@FindBy(xpath = ".//div[@id='login_error']")
	private List<WebElement> divLoginError;

	public LoginPage(WebDriver driver) {
		super.driver = driver;
	}

	public BasePageObject doLogin(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		if (divLoginError.isEmpty()) {
			return new DashBoardPage(driver);
		} else
			return this;
	}

	public boolean verifyError(String errorMessage) {
		if (divLoginError.get(0).isDisplayed()) {
			if (divLoginError.get(0).getText().contains(errorMessage)) {
				return true;
			}
		}
		return false;
	}
}
