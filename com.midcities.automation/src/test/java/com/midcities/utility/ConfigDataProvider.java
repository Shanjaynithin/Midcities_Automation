package com.midcities.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Config/config.properties");

		try {
			
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
			
			fis.close();

		} catch (Exception e) {

			System.out.println("Configuration file not loaded>>" + e.getMessage());
		}
	}

	public String getDataFromConfig(String keyToSearch) {

		return pro.getProperty(keyToSearch);
		
	}

	public String getBrowser() {
		
		return pro.getProperty("Browser");
	}

	public String getUrl() {
		
		return pro.getProperty("stagUrl");

	}
}
