package login;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.Helpers;
import helpers.ScreenShot;


public class Principal {

	private WebDriver driver;
	private String numeroCliente;
	private String claveAcceso;
	private String challng;
	private String urlLogin;
	private String urlChallng;
	 

	int time1 = 1;
	int time2 = 2;
	int time3 = 3;
	int time4 = 4;
	int time5 = 5;
	
	public Principal(){
		numeroCliente = "12345678";
		claveAcceso = "87654321";
		challng = "challeng";
		urlLogin = "https://www.banamex.com/resources/bancanets/bne/esp/DemoBNE/index_m.html";
		urlChallng = "https://www.banamex.com/resources/bancanets/bne/esp/DemoBNE/login/challng.html";
	}

	@Before
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(urlLogin);
		Helpers seconds = new Helpers();
		seconds.seconds(time3);
		ScreenShot screenshot = new ScreenShot(driver);
		screenshot.screenShot("1");
		System.out.println("Inicia navegador");

	}

	@Test
	public void bneTesting() throws IOException {
		Login login = new Login(driver);
		login.loginAccess(numeroCliente, claveAcceso);
		login.challng(challng);
		login.cargaArchivo();

		System.out.println("Termina el test");
	}

	@After
	public void tearDown() {
		System.out.println("Termina procesos");
		driver.close();
	}

}
