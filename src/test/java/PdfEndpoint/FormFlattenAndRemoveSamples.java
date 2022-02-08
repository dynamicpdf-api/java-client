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

public class FormFlattenAndRemoveSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void pdfInputFilePath_Field_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		field.setFlatten(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		field1.setFlatten(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		field2.setFlatten(true);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field3.setFlatten(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field4.setFlatten(false);
		pdf.getFormFields().add(field4);

		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		field5.setFlatten(true);
		pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput1.pdf");
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
	public void pdfInputStream_FormFlattenField_Pdfoutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
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

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		field.setFlatten(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		field1.setFlatten(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		field2.setFlatten(true);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field3.setFlatten(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field4.setFlatten(false);
		pdf.getFormFields().add(field4);

		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		field5.setFlatten(true);
		pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput2.pdf");
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
	public void pdfInputBytes_FormFlattenField_Pdfoutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		field.setFlatten(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		field1.setFlatten(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		field2.setFlatten(true);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field3.setFlatten(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field4.setFlatten(false);
		pdf.getFormFields().add(field4);

		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		field5.setFlatten(true);
		pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput3.pdf");
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
	public void pdfInputCloudRoot_FormFlattenField_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		field.setFlatten(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		field1.setFlatten(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		field2.setFlatten(true);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field3.setFlatten(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field4.setFlatten(false);
		pdf.getFormFields().add(field4);

		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		field5.setFlatten(true);
		pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput4.pdf");
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
	public void pdfInputCloudSubFolder_FormFlattenField_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		field.setFlatten(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		field1.setFlatten(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		field2.setFlatten(true);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field3.setFlatten(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field4.setFlatten(false);
		pdf.getFormFields().add(field4);

		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		field5.setFlatten(true);
		pdf.getFormFields().add(field5);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput5.pdf");
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
	public void pdfInputFilePath_FormFlattenFieldRemove_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]");
		field.setRemove(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]");
		field1.setRemove(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field2.setRemove(false);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field3.setRemove(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].f1_9[0]");
		field4.setRemove(true);
		pdf.getFormFields().add(field4);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput6.pdf");
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
	public void pdfInputStream_FormFlattenFieldRemove_Pdfoutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
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

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]");
		field.setRemove(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]");
		field1.setRemove(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field2.setRemove(false);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field3.setRemove(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].f1_9[0]");
		field4.setRemove(true);
		pdf.getFormFields().add(field4);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput7.pdf");
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
	public void pdfInputBytes_FormFlattenFieldRemove_Pdfoutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]");
		field.setRemove(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]");
		field1.setRemove(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field2.setRemove(false);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field3.setRemove(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].f1_9[0]");
		field4.setRemove(true);
		pdf.getFormFields().add(field4);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput8.pdf");
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
	public void pdfInputUsingCloudRoot_FormFlattenFieldRemove_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]");
		field.setRemove(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]");
		field1.setRemove(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field2.setRemove(false);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field3.setRemove(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].f1_9[0]");
		field4.setRemove(true);
		pdf.getFormFields().add(field4);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput9.pdf");
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
	public void pdfInputUsingCloudSubFolder_FormFlattenFieldRemove_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]");
		field.setRemove(true);
		pdf.getFormFields().add(field);

		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]");
		field1.setRemove(true);
		pdf.getFormFields().add(field1);

		FormField field2 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		field2.setRemove(false);
		pdf.getFormFields().add(field2);

		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		field3.setRemove(false);
		pdf.getFormFields().add(field3);

		FormField field4 = new FormField("topmostSubform[0].Page1[0].f1_9[0]");
		field4.setRemove(true);
		pdf.getFormFields().add(field4);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput10.pdf");
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
	public void pdfInputUsingFilePath_FormFlattenAllFields_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		pdf.getFormFields().add(field8);

		pdf.setFlattenAllFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput11.pdf");
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
	public void pdfInputUsingStream_FormFlattenAllFields_Pdfoutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
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

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		pdf.getFormFields().add(field8);

		pdf.setFlattenAllFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput12.pdf");
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
	public void pdfInputUsingBytes_FormFlattenAllFields_Pdfoutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		pdf.getFormFields().add(field8);

		pdf.setFlattenAllFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput13.pdf");
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
	public void pdfInputUsingCloudRoot_AllFields_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		pdf.getFormFields().add(field8);

		pdf.setFlattenAllFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput14.pdf");
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
	public void pdfInputUsingCloudSubFolder_AllFields_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/fw9AcroForm_14.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("topmostSubform[0].Page1[0].f1_1[0]", "Any Company, Inc.");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("topmostSubform[0].Page1[0].f1_2[0]", "Any Company");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("topmostSubform[0].Page1[0].FederalClassification[0].c1_1[0]", "1");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_7[0]", "123 Main Street");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("topmostSubform[0].Page1[0].Address[0].f1_8[0]", "Washington, DC  22222");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("topmostSubform[0].Page1[0].f1_9[0]", "Any Requester");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("topmostSubform[0].Page1[0].f1_10[0]", "17288825617");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_14[0]", "52");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("topmostSubform[0].Page1[0].EmployerID[0].f1_15[0]", "1234567");
		pdf.getFormFields().add(field8);

		pdf.setFlattenAllFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput15.pdf");
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
	public void pdfInputUsingFilePath_RetainSignature_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Org.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput16.pdf");
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
	public void pdfInputUsingStream_RetainSignature_Pdfoutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\Org.pdf");
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

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput17.pdf");
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
	public void pdfInputUsingBytes_RetainSignature_Pdfoutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Org.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput18.pdf");
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
	public void pdfInputUsingCloudRoot_RetainSignature_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Org.pdf");
		pdf.getInputs().add(input);

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput19.pdf");
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
	public void pdfInputUsingCloudSubFolder_RetainSignature_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/Org.pdf");
		pdf.getInputs().add(input);

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFlattenOutput20.pdf");
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
