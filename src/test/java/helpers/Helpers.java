package helpers;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class Helpers {
	ArrayList<String> tabs;

	public void seconds(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void switchToWindow(WebDriver driver, int tab) {

		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));

	}

}
