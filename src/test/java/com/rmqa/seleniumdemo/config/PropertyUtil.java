package com.rmqa.seleniumdemo.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static String getProperties() {
		String browserName = null;
		try {
			Properties props = new Properties();

			String filePath = System.getProperty("user.dir")
					+ "/src/test/java/com/rmqa/seleniumdemo/config/config.properties";
			InputStream input = new FileInputStream(filePath);
			props.load(input);
			browserName = props.getProperty("browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return browserName;
	}

}
