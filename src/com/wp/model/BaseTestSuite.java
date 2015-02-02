package com.wp.model;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.wp.util.ConfigurationProvider;

import junit.framework.TestSuite;

public class BaseTestSuite extends TestSuite{

	protected WebDriver driver;
	
	@Before
	public void setUp(){
		this.driver=new FirefoxDriver();
		this.driver.get(ConfigurationProvider.getInstance().getLocalUrl());
	}
	
	@After
	public void tearDown(){
		this.driver.close();
	}
	
}
