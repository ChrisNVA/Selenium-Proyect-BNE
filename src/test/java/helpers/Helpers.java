package helpers;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
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

	// public static void main(String[] args) throws IOException,
	// InvalidFormatException {
	// XWPFDocument docx = new XWPFDocument();
	// XWPFParagraph par = docx.createParagraph();
	// XWPFRun run = par.createRun();
	// run.setText("Texto dentro del word");
	// run.setFontSize(13);
	// InputStream pic = new FileInputStream(
	// "C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS
	// WS\\BNE\\ScreenShots\\1540226980214-7.png");
	// run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, "1", Units.toEMU(500),
	// Units.toEMU(200));
	// InputStream pic2 = new FileInputStream(
	// "C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS
	// WS\\BNE\\ScreenShots\\1540226949758-1.png");
	// run.addPicture(pic2, XWPFDocument.PICTURE_TYPE_PNG, "1",
	// Units.toEMU(500), Units.toEMU(200));
	// FileOutputStream out = new FileOutputStream(
	// "C:\\Users\\OCTAVIO\\Desktop\\Nueva carpeta\\STS WS\\BNE\\prueba2.doc");
	// docx.write(out);
	// out.close();
	// pic.close();
	// pic2.close();
	// docx.close();
	// System.out.println("termino");
	//
	// }
	// public void agregaCaracter(String caracter){
	//// String str = "Esta / es / una prueba";
	// String nuevaCadena = "";
	// char prueba = '\';
	// for (int n = 0; n < caracter.length(); n++) {
	// char c = caracter.charAt(n);
	// //System.out.println("antes de entrar al if");
	// if (c == prueba) {
	// //System.out.println("dentro del if");
	// nuevaCadena = nuevaCadena + c + c;
	// } else {
	// nuevaCadena = nuevaCadena + c;
	// }
	//
	// }
	//
	// System.out.println(nuevaCadena);
	// }
	
	public String agregaCero(int dato){
		String datoFinal;
		
		if (dato <= 9){
			datoFinal = "0" + dato;
		}else{
			datoFinal = "" + dato;
		}
		return datoFinal;
	}

	public void CrearWord() throws IOException, InvalidFormatException {
        int horas, minutos, segundos;
        int dia, mes, ano;
        String nombreDocumento;
		int mesR;
		Helpers helper = new Helpers();
		Calendar calendario = new GregorianCalendar();
        horas = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        mes = calendario.get(Calendar.MONTH) + 1;
        System.out.println("este es el mes: " + mes);
  //      mesR=calendario.get(Calendar.DATE);
        ano = calendario.get(Calendar.YEAR);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        nombreDocumento = "BNE-" + helper.agregaCero(dia) + helper.agregaCero(mes) + ano + "-"+ helper.agregaCero(horas) + helper.agregaCero(minutos) + helper.agregaCero(segundos) + ".doc";
        System.out.println(nombreDocumento);
        
		File file = new File(nombreDocumento);
		if (file.createNewFile()) {
			final File carpeta = new File("ScreenShots\\");

			// FileWriter fw = new FileWriter(file);
			// BufferedWriter bw = new BufferedWriter(fw);
			// PrintWriter wr = new PrintWriter(bw);
			String ruta;
			int nPaso = 0;

			XWPFDocument docx = new XWPFDocument();
			XWPFParagraph par = docx.createParagraph();
			XWPFRun run = par.createRun();

			for (final File ficheroEntrada : carpeta.listFiles()) {
				// System.out.println(ficheroEntrada.getName());
				// wr.write(ficheroEntrada.getName());
				// wr.write(ficheroEntrada.getAbsolutePath());
				ruta = ficheroEntrada.getAbsolutePath();
				nPaso = nPaso + 1;
				run.setText("Paso número: " + nPaso);
				// run.setText(ficheroEntrada.getName());
				run.setFontSize(13);
				InputStream pic = new FileInputStream(ruta);
				run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, "1", Units.toEMU(500), Units.toEMU(200));

			}
			System.out.println(file.getAbsolutePath());
			FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
			docx.write(out);
			out.close();
			((Closeable) docx).close();
			// wr.close();
			// bw.close();
			// fw.close();
			System.out.println("Word Creado");
		}

	}

}
