package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReadData {

	Properties prop;

	public ConfigReadData() throws Exception {

		FileInputStream fis = new FileInputStream("./configFolder/config.properties");
		prop = new Properties();
		prop.load(fis);

	}

	public String getAppURL() {

		return prop.getProperty("appURL1");
	}

	public String getuserName() {

		return prop.getProperty("adminEmail");
	}
	
	public String getPassword() {

		return prop.getProperty("adminPass");
	}

}
