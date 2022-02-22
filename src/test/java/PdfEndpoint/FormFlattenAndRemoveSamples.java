package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
	public void PdfInputFilePath_FormFlattenField_Pdfoutput() 
	{
		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\fw9AcroForm_14.pdf");
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
			File file = new File("src\\test\\outputs\\FormFlattenField.pdf");
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
	public void pdfInputUsingCloudRoot_FormFlattenFieldRemove_Pdfoutput() 
	{
		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("TFWResources/fw9AcroForm_14.pdf");
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
			File file = new File("src\\test\\outputs\\FormFlattenFieldRemove.pdf");
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
	public void pdfInputUsingStream_FormFlattenAllFields_Pdfoutput()
	{
		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\fw9AcroForm_14.pdf");
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
			File file = new File("src\\test\\outputs\\FormFlattenAllFields.pdf");
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
	public void pdfInputUsingFilePath_RetainSignature_Pdfoutput()
	{
		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\Signature.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		pdf.setFlattenAllFormFields(true);
		pdf.setRetainSignatureFormFields(true);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\RetainSignatureFormFields.pdf");
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
