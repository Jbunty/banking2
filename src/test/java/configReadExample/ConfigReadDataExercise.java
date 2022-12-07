package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReadDataExercise {

	Properties prop;

	public ConfigReadDataExercise() throws Exception {

		FileInputStream fis = new FileInputStream("./configFolder/exercise.properties");
		prop = new Properties();
		prop.load(fis);

	}

	public String getAppURL() {

		return prop.getProperty("appURL");
	}

	public String getuserName() {

		return prop.getProperty("username");
	}
	
	public String getPassword() {

		return prop.getProperty("password");
	}

}
