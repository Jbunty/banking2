package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigRead {

	Properties prop;

	public ConfigRead() throws Exception {

		FileInputStream fis = new FileInputStream("./configFolder/data.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String getApplicationURL() {

		String appURL = prop.getProperty("url");
		return appURL;

	}

	public String getApplicationURL_QA() {

		String appURL = prop.getProperty("url_qa");
		return appURL;

	}
	
	public String adming_userName() {

		String appURL = prop.getProperty("userName");
		return appURL;

	}
	
	public String admin_password() {

		String appURL = prop.getProperty("password");
		return appURL;

	}

}
