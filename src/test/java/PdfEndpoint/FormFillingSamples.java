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

public class FormFillingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void pdfInputFilePath_PdfOutput() {

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

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput1.pdf");
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
	public void pdfInputStream_PdfOutput() {

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

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput2.pdf");
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
	public void pdfInputBytes_PdfOutput() {

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

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput3.pdf");
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
	public void pdfInputCloudRoot_FormFill_PdfOutput() {

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

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput4.pdf");
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
	public void pdfInputCloudSubFolder_PdfOutput() {

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

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput5.pdf");
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
	public void PdfInputFilePath_TextBox_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("txtfname", "My Text");
		pdf.getFormFields().add(field);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput6.pdf");
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
	public void pdfInputFilePath_ComboBox_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("cmbname", "Item3");
		pdf.getFormFields().add(field);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput7.pdf");
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
	public void pdfInputFilePath_ListBox_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("lbname", "Item 4");
		pdf.getFormFields().add(field);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput8.pdf");
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
	public void pdfInputFilePath_RadioButton_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("rbname", "Radio2");
		pdf.getFormFields().add(field);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput9.pdf");
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
	public void pdfInputFilePath_CheckBox_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("cbxname", "Yes");
		pdf.getFormFields().add(field);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput10.pdf");
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
	public void pdfInputFilePath_XfaFormFill_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("form1[0].#subform[0].TextField1[0]", "text");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("form1[0].#subform[0].DateField1[0]", "07/03/0217");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("form1[0].#subform[0].NumericField1[0]", "2594");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("form1[0].#subform[0].DecimalField1[0]", "25.94");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[0]", "1");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[2]", "1");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("form1[0].#subform[0].Subform1[1].RadioButtonList[1]", "1");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("form1[0].#subform[0].ListBox1[0]", "Full Time");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("form1[0].#subform[0].DropDownList1[0]", "Third");
		pdf.getFormFields().add(field8);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput11.pdf");
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
	public void pdfInputStream_Xfa_Pdfoutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
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

		FormField field = new FormField("form1[0].#subform[0].TextField1[0]", "text");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("form1[0].#subform[0].DateField1[0]", "07/03/0217");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("form1[0].#subform[0].NumericField1[0]", "2594");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("form1[0].#subform[0].DecimalField1[0]", "25.94");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[0]", "1");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[2]", "1");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("form1[0].#subform[0].Subform1[1].RadioButtonList[1]", "1");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("form1[0].#subform[0].ListBox1[0]", "Full Time");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("form1[0].#subform[0].DropDownList1[0]", "Third");
		pdf.getFormFields().add(field8);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput12.pdf");
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
	public void pdfInputBytes_Xfa_Pdfoutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("form1[0].#subform[0].TextField1[0]", "text");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("form1[0].#subform[0].DateField1[0]", "07/03/0217");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("form1[0].#subform[0].NumericField1[0]", "2594");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("form1[0].#subform[0].DecimalField1[0]", "25.94");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[0]", "1");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[2]", "1");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("form1[0].#subform[0].Subform1[1].RadioButtonList[1]", "1");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("form1[0].#subform[0].ListBox1[0]", "Full Time");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("form1[0].#subform[0].DropDownList1[0]", "Third");
		pdf.getFormFields().add(field8);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput13.pdf");
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
	public void pdfInputCloudRoot_Xfa_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("All Fields Sample.pdf");
		pdf.getInputs().add(input);

		FormField field = new FormField("form1[0].#subform[0].TextField1[0]", "text");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("form1[0].#subform[0].DateField1[0]", "07/03/0217");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("form1[0].#subform[0].NumericField1[0]", "2594");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("form1[0].#subform[0].DecimalField1[0]", "25.94");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[0]", "1");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[2]", "1");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("form1[0].#subform[0].Subform1[1].RadioButtonList[1]", "1");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("form1[0].#subform[0].ListBox1[0]", "Full Time");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("form1[0].#subform[0].DropDownList1[0]", "Third");
		pdf.getFormFields().add(field8);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput14.pdf");
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
	public void pdfInputCloudSubFolder_XfaFormFill_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\All Fields Sample.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		FormField field = new FormField("form1[0].#subform[0].TextField1[0]", "text");
		pdf.getFormFields().add(field);
		FormField field1 = new FormField("form1[0].#subform[0].DateField1[0]", "07/03/0217");
		pdf.getFormFields().add(field1);
		FormField field2 = new FormField("form1[0].#subform[0].NumericField1[0]", "2594");
		pdf.getFormFields().add(field2);
		FormField field3 = new FormField("form1[0].#subform[0].DecimalField1[0]", "25.94");
		pdf.getFormFields().add(field3);
		FormField field4 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[0]", "1");
		pdf.getFormFields().add(field4);
		FormField field5 = new FormField("form1[0].#subform[0].Subform1[0].CheckBox1[2]", "1");
		pdf.getFormFields().add(field5);
		FormField field6 = new FormField("form1[0].#subform[0].Subform1[1].RadioButtonList[1]", "1");
		pdf.getFormFields().add(field6);
		FormField field7 = new FormField("form1[0].#subform[0].ListBox1[0]", "Full Time");
		pdf.getFormFields().add(field7);
		FormField field8 = new FormField("form1[0].#subform[0].DropDownList1[0]", "Third");
		pdf.getFormFields().add(field8);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FormFillingOutput15.pdf");
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
