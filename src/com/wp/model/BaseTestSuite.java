package com.wp.model;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestSuite;

public class BaseTestSuite extends TestSuite{

	protected WebDriver driver;
	
	@Before
	public void setUp(){
		this.driver=new FirefoxDriver();
		this.driver.get("http://192.168.59.103:8080/wp-login.php");
	}
	
	@After
	public void tearDown(){
		this.driver.close();
	}
	
}
