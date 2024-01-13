package com.music.configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {
	private Properties properties;
	
	String projectPath = System.getProperty("user.dir")+"/";
	private String propertiesPath = "src/main/resources/";
	
	
	public PropertiesFile (String testcase) {
		properties = new Properties();
		
		try {
			FileInputStream fileIn = new FileInputStream(projectPath + propertiesPath + testcase +".properties");
			properties.load(fileIn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public void setPropertiesFile (String testcase) {
		properties = new Properties();
		
		try {
			FileInputStream fileIn = new FileInputStream(projectPath + propertiesPath + testcase +".properties");
			properties.load(fileIn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public String getPropValue (String keyProp) {
		String value = null;
		try {
			value = properties.getProperty(keyProp);
			return value;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return value;
	}
	
	public void setPropValue (String key, String value) {
		try {
			FileOutputStream fileOut = new FileOutputStream(projectPath + propertiesPath);
			properties.setProperty(key, value);
			properties.store(fileOut, "set new value");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
