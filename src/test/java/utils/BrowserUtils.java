package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BrowserUtils {
	
	
	public static String getScreenshot(String name) {
		
		//name the screenshot with current date
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		WaitUtils.pauseFor(2);
		TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
		
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		//path to the screenshot location
		String target = System.getProperty("user.dir") + "/test-output/Screenshots"+name+time+".png";
		
		File finalDestination = new File(target);
		
		try {
			FileUtils.copyFile(source, finalDestination);
		}catch (IOException io) {
			io.printStackTrace();
		}
		
		
		return target;
	}
	

}
