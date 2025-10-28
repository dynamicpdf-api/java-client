package PdfSecurityEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfSecurityInfoEndpoint;
import com.dynamicpdf.api.PdfSecurityInfoResponse;
import com.dynamicpdf.api.PdfResource;

public class PdfSecurityInfoSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		PdfSecurityInfoEndpoint.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfSecurityInfoEndpoint.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void Aes128PdfSecurityInfo() {

		PdfResource resource = new PdfResource("src\\test\\resources\\Aes128Security.pdf");

		PdfSecurityInfoEndpoint pdfInfo = new PdfSecurityInfoEndpoint(resource);
		PdfSecurityInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\Aes128PdfSecurity_JsonOutput.json");
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(response.getJsonContent());
				fw.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void Aes256PdfSecurityInfo() {

		PdfResource resource = new PdfResource("src\\test\\resources\\Aes256Security.pdf");

		PdfSecurityInfoEndpoint pdfInfo = new PdfSecurityInfoEndpoint(resource);
		PdfSecurityInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\Aes256PdfSecurity_JsonOutput.json");
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(response.getJsonContent());
				fw.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void Rc4128PdfSecurityInfo() {

		PdfResource resource = new PdfResource("src\\test\\resources\\Rc4128Security.pdf");

		PdfSecurityInfoEndpoint pdfInfo = new PdfSecurityInfoEndpoint(resource);
		PdfSecurityInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\Rc4128PdfSecurity_JsonOutput.json");
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(response.getJsonContent());
				fw.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void Rc440PdfSecurityInfo() {

		PdfResource resource = new PdfResource("src\\test\\resources\\Rc440Security.pdf");

		PdfSecurityInfoEndpoint pdfInfo = new PdfSecurityInfoEndpoint(resource);
		PdfSecurityInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\Rc440PdfSecurity_JsonOutput.json");
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(response.getJsonContent());
				fw.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

}
