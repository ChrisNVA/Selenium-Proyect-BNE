package helpers;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	private WebDriver driver;
	private int contador;
	Date date;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
		contador = 1;

	}

	public void screenShot(String nombre) throws IOException {
		File directorio=new File("ScreenShots"); 
		directorio.mkdir();
		
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenShot,
//				new File("C:\\Users\\OCTAVIO\\Desktop\\Selenium\\Screenshot\\" + contador + nombre + ".jpg"));
		FileUtils.copyFile(screenShot,
				new File("ScreenShots\\" + System.currentTimeMillis() + "-" + nombre + ".png"));
		contador = contador + 1;
	}

}
