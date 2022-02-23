package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;

public class SecuritySamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void pdfInputFilePathAes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		security.setAllowFormFilling(false);
		security.setAllowUpdateAnnotsAndFields(false);
		security.setAllowEdit(false);
		security.setDocumentComponents(EncryptDocumentComponents.ALLEXCEPTMETADATA);
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\SecurityAes256.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void pageInput_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("", "");
		security.setOwnerPassword("owner");
		security.setUserPassword("user");
		security.setAllowDocumentAssembly(false);
		security.setAllowEdit(false);
		security.setDocumentComponents(EncryptDocumentComponents.ALL);		
		pdf.setSecurity(security);

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\SecurityAes128.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void pdfInputUsingCloudRoot_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("TFWResources/XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		security.setAllowHighResolutionPrinting(true);
		security.setAllowPrint(true);
		security.setEncryptMetadata(true);
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\SecurityRC4128.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}
