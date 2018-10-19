package helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(tab));

	}

	public void CrearWord() throws IOException {

		File file = new File("C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS WS\\BNE\\prueba2.doc");
		if (file.createNewFile()) {
			final File carpeta = new File("C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS WS\\BNE\\ScreenShots\\");

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter wr = new PrintWriter(bw);
			// FileImageInputStream imagen = new FileImageInputStream(carpeta);

			wr.write("Hola mundo");
			
			//https://es.stackoverflow.com/questions/74521/c%C3%B3mo-guardar-un-bufferedimage-como-una-imagen-png-en-java
			BufferedImagen imagen = ImageIO.read(new File("imagen.png"));
			File outputfile = new File("../desktop/nuevoNombre.png");
			ImageIO.write("C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS WS\\BNE\\ScreenShots\\", "png", outputfile);
			
			
			for (final File ficheroEntrada : carpeta.listFiles()) {
				System.out.println(ficheroEntrada.getName());
				wr.write(ficheroEntrada.getName());
				wr.write(ficheroEntrada.getAbsolutePath());
				wr.write(ficheroEntrada.getAbsoluteFile());
				
				
				
			}
			wr.close();
			bw.close();
			fw.close();
			System.out.println("Word Creado");
		}

	}



}
