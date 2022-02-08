package PdfEndpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput1.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputBytesAes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput2.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputStream_Aes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(targetStream);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput3.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputCloudRoot_Aes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput4.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputSubFolder_Aes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput5.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pageInput_Aes256Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput6.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInpuAes256SecurityOwnerPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes256Security security = new Aes256Security("", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput7.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputAes256SecurityAllowFormFillingAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("user", "owner");
		security.setAllowFormFilling(false);
		security.setAllowUpdateAnnotsAndFields(false);
		security.setAllowEdit(false);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput8.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputAes256SecurityAllowPrintAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("user", "owner");
		security.setAllowHighResolutionPrinting(true);
		security.setAllowPrint(true);
		security.setAllowCopy(true);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput9.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputFilePath_Aes256SecurityOwnerUserPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("", "");
		security.setAllowAccessibility(true);
		security.setAllowDocumentAssembly(false);
		security.setAllowEdit(false);
		security.setOwnerPassword("owner");
		security.setUserPassword("user");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput10.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInput_Aes256SecurityDocumentComponentsAll_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("user", "owner");
		security.setDocumentComponents(EncryptDocumentComponents.ALL);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput11.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes256SecurityDocumentComponentsAllExceptMetadata_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("user", "owner");
		security.setDocumentComponents(EncryptDocumentComponents.ALLEXCEPTMETADATA);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput12.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes256SecurityWithoutPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes256Security security = new Aes256Security("", "");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput13.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput18.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingBytes_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput14.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingStream_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(targetStream);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput15.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingCloudRoot_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput16.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingCloudSubFolder_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput17.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pageInput_Aes128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("user", "owner");
		pdf.setSecurity(security);

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput19.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityOwnerPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("", "owner");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput20.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityAllowFormFillingAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("user", "owner");
		security.setAllowFormFilling(false);
		security.setAllowUpdateAnnotsAndFields(false);
		security.setAllowEdit(false);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput21.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityAllowPrintAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("user", "owner");
		security.setAllowHighResolutionPrinting(true);
		security.setAllowPrint(true);
		security.setAllowCopy(true);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput22.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityUserOwnerPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("", "");
		security.setAllowAccessibility(true);
		security.setAllowDocumentAssembly(false);
		security.setAllowEdit(false);
		security.setOwnerPassword("owner");
		security.setUserPassword("user");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput23.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityDocumentComponentsAll_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("user", "owner");
		security.setDocumentComponents(EncryptDocumentComponents.ALL);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput24.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityDocumentComponentsAllExceptMetadata_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("user", "owner");
		security.setDocumentComponents(EncryptDocumentComponents.ALLEXCEPTMETADATA);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput25.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_Aes128SecurityWithoutPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		Aes128Security security = new Aes128Security("", "");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput26.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput27.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingBytes_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput28.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingStream_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(targetStream);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput29.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingCloudRoot_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput30.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingCloudSubFolder_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/XmpAndOtherSample.pdf");
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput31.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pageInput_RC4128Security_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("user", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput32.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityOwnerPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		RC4128Security security = new RC4128Security("", "owner");
		pdf.setSecurity(security);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput33.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityAllowFormFillingAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("user", "owner");
		security.setAllowFormFilling(false);
		security.setAllowUpdateAnnotsAndFields(false);
		security.setAllowEdit(false);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput34.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityAllowPrintAndOtherProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("user", "owner");
		security.setAllowHighResolutionPrinting(true);
		security.setAllowPrint(true);
		security.setAllowCopy(true);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput35.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityOwnerUserPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("", "");
		security.setAllowAccessibility(true);
		security.setAllowDocumentAssembly(false);
		security.setAllowEdit(false);
		security.setOwnerPassword("owner");
		security.setUserPassword("user");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput36.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityEncryptMetadata_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("user", "owner");
		security.setEncryptMetadata(true);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput37.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityEncryptExceptMetadata_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("user", "owner");
		security.setEncryptMetadata(false);
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput38.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public void pdfInputUsingFilePath_RC4128SecurityWithoutPassword_PdfOutput() {

		Pdf pdf = new Pdf();

		RC4128Security security = new RC4128Security("", "");
		pdf.setSecurity(security);

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\XmpAndOtherSample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\SecurityOutput39.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
}
