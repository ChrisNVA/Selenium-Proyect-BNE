package login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;
import helpers.ScreenShot;

public class Login {

	private WebDriver driver;
	private By txtUser;
	private By txtPass;
	private By buttonEntrar;
	private By txtChallng;
	private By buttonContinuar;
	private By transferenciasPagosMenu;
	private By tranferenciasMasivasMenu;
	private By lnkCargarArchivo;
	private By buttonExaminar;
	private By txtSeleccionaArchivo;
	private By buttonValidar;
	// ArrayList<String> tabs;

	public Login(WebDriver driver) {
		this.driver = driver;
		txtUser = By.id("USERID");
		txtPass = By.id("PASSWORD");
		buttonEntrar = By.id("t25");
		txtChallng = By.id("PASSWORD_FDD");
		buttonContinuar = By.id("t21");
		transferenciasPagosMenu = By.xpath("//*[@id='menu']/ul/li[2]/a");
		tranferenciasMasivasMenu = By.xpath("//*[@id='menu-second2']/div[2]/div[3]/a/span[3]");
		lnkCargarArchivo = By.xpath("/html/body/div[1]/div[8]/table/tbody/tr/td[1]/div[1]/div[2]/a");
		//buttonExaminar = By.id("Numcuentas");
		// buttonExaminar = By.id("nomarchivo");
		txtSeleccionaArchivo = By.xpath("/html/body/div/div[3]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]");
		
		
		
		buttonValidar = By.xpath("/html/body/div/div[4]/input");

	}

	public void loginAccess(String user, String pass) throws IOException {
		Helpers helpers = new Helpers();
		ScreenShot screenshot = new ScreenShot(driver);
		driver.findElement(txtUser).clear();
		helpers.seconds(3);
		driver.findElement(txtUser).sendKeys(user);
		screenshot.screenShot("2");
		helpers.seconds(3);
		driver.findElement(txtPass).clear();
		helpers.seconds(3);
		driver.findElement(txtPass).sendKeys(pass);
		screenshot.screenShot("3");
		helpers.seconds(3);
		driver.findElement(buttonEntrar).click();
		screenshot.screenShot("4");
		// helpers.seconds(3);

	}

	public void challng(String challng) throws IOException {

		// tabs = new ArrayList<String> (driver.getWindowHandles());
		// driver.switchTo().window(tabs.get(1));
		Helpers helpers = new Helpers();
		ScreenShot screenshot = new ScreenShot(driver);
		helpers.switchToWindow(driver, 1);
		helpers.seconds(3);
		driver.findElement(txtChallng).clear();
		helpers.seconds(2);
		driver.findElement(txtChallng).sendKeys(challng);
		screenshot.screenShot("5");
		helpers.seconds(2);
		driver.findElement(buttonContinuar).click();
		helpers.seconds(2);

	}

	public void cargaArchivo() throws IOException {
		Helpers helpers = new Helpers();
		ScreenShot screenshot  = new ScreenShot(driver);
		helpers.seconds(2);
		driver.findElement(transferenciasPagosMenu).click();
		screenshot.screenShot("6");
		helpers.seconds(2);
		driver.findElement(tranferenciasMasivasMenu).click();
		screenshot.screenShot("7");
		helpers.seconds(2);
		driver.findElement(lnkCargarArchivo).click();
		screenshot.screenShot("8");
		helpers.seconds(10);
		helpers.CrearWord();
		
		// ERROR
		// driver.findElement(buttonValidar).click();
		// helpers.seconds(4);
		 driver.findElement(txtSeleccionaArchivo).click();
		 helpers.seconds(5);
		driver.findElement(buttonExaminar).click();
		// Highlight (driver.findElement(buttonExaminar).click());
		helpers.seconds(10);
		System.out.println("Cargar Archivo");

	}

}
