package com.wp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProvider {

	private static ConfigurationProvider instance = null;
	private Properties localProperties;

	protected ConfigurationProvider() {
		this.getLocalProperties();
	}

	public static ConfigurationProvider getInstance() {
		if (instance == null) {
			instance = new ConfigurationProvider();			
		}
		return instance;
	}
	
	public String getLocalUrl(){
		return localProperties.getProperty("local_url");
	}
	
	private void getLocalProperties(){
		File file=new File("properties/local.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		localProperties= new Properties();
		try {
			localProperties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
