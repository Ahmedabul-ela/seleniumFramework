package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {

	public static Properties userdata
	           = loadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\userdata.properties");
	 //saucelabs
	public static Properties saucelabsuserdata
	           = loadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\sauceladuser.properties");
	
	private static Properties loadProperities(String path) {
		Properties pro = new Properties();
		try{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		}catch (FileNotFoundException e) {
			System.out.println("eror: "+ e.getMessage());
		}catch (IOException e1) {
			System.out.println("eror: "+ e1.getMessage());
		}
		return pro;
	}
}