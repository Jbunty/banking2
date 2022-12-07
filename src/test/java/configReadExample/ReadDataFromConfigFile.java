package configReadExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromConfigFile {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("./configFolder/data.properties");
		
		
		Properties prop = new Properties();
		
		
		prop.load(fis);
		
		
		
		System.out.println("APplication URL : " + prop.getProperty("url"));
		System.out.println("userName : " + prop.getProperty("userName"));
		System.out.println("password : " + prop.getProperty("password"));

	}

}
