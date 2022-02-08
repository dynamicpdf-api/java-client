package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.DlexInput;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.PageNumberingElement;
import com.dynamicpdf.api.elements.TextElement;

public class DlexInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void SimpleDlex_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = new DlexInput(dlex, layoutData);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	
	@Test
	public void SimpleDlex_Cloud_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = new DlexInput("SimpleReportWithCoverPage.dlex", layoutData);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput1.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	/*
	 * @Test public void SimpleDlex_CloudData_Pdfoutput() {
	 * 
	 * Pdf pdf = new Pdf(); pdf.setAuthor("Author"); pdf.setTitle("Title");
	 * 
	 * String jsonString = null;
	 * 
	 * try { jsonString = new String(Files.readAllBytes(Paths.get(
	 * "src\\test\\resources\\PdfEndpoint\\SimpleReportData.json"))); } catch
	 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * DlexInput input = new DlexInput("SimpleReportWithCoverPage.dlex",
	 * jsonString); pdf.getInputs().add(input);
	 * 
	 * PdfResponse response = pdf.process();
	 * 
	 * if (response.getIsSuccessful()){ File file = new
	 * File("C:\\Data\\outputs\\javaOutput2.pdf"); try { OutputStream os = new
	 * FileOutputStream(file); os.write(response.getContent()); os.close(); } catch
	 * (Exception e) { System.out.println("Exception: " + e); } } }
	 */
	
	@Test
	public void Template_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = new DlexInput(dlex, layoutData);
		
		Template template = new Template("temp1");
        TextElement textElement = new TextElement("HelloWorld", ElementPlacement.TOPRIGHT);
        template.getElements().add(textElement);
        input.setTemplate(template);
        
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput3.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public void PagenumberingLabelWithTemplate_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = new DlexInput(dlex, layoutData);
		
		Template template = new Template("temp1");
		PageNumberingElement textElement = new PageNumberingElement("%%CP%%", ElementPlacement.TOPRIGHT);
        template.getElements().add(textElement);
        input.setTemplate(template);
        
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput4.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public void SimpleDlex_AddDlex_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = pdf.addDlex(dlex, layoutData);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput5.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	@Test
	public void SimpleDlex_AddDlexCloudResource_Pdfoutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
		DlexInput input = pdf.addDlex("SimpleReportWithCoverPage.dlex", layoutData);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\javaOutput6.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}
	
	/*
	 * @Test public void SimpleDlex_AddDlexCloudResourceData_Pdfoutput() {
	 * 
	 * Pdf pdf = new Pdf(); pdf.setAuthor("Author"); pdf.setTitle("Title");
	 * 
	 * String jsonString = null;
	 * 
	 * try { jsonString = new String(Files.readAllBytes(Paths.get(
	 * "src\\test\\resources\\PdfEndpoint\\SimpleReportData.json"))); } catch
	 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * DlexInput input = pdf.addDlex("SimpleReportWithCoverPage.dlex", jsonString);
	 * pdf.getInputs().add(input);
	 * 
	 * PdfResponse response = pdf.process();
	 * 
	 * if (response.getIsSuccessful()){ File file = new
	 * File("C:\\Data\\outputs\\javaOutput7.pdf"); try { OutputStream os = new
	 * FileOutputStream(file); os.write(response.getContent()); os.close(); } catch
	 * (Exception e) { System.out.println("Exception: " + e); } } }
	 */
	
	@Test
	public static void SimpleDlexWithJsonString_Pdfoutput() {

		String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Pdf pdf = new Pdf();
		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");

		DlexInput input = new DlexInput(dlex, jsonString);
		pdf.getInputs().add(input);
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Output8.pdf");
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
	public static void SimpleDlexWithJsonString_CloudResource_Pdfoutput() {

		String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Pdf pdf = new Pdf();
		DlexInput input = new DlexInput("SimpleReportWithCoverPage.dlex", jsonString);
		pdf.getInputs().add(input);
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Output9.pdf");
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
	public static void SimpleDlexWithJsonString_AddDlexCloudResource_Pdfoutput() {

        String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Pdf pdf = new Pdf();
		DlexInput input = pdf.addDlex("SimpleReportWithCoverPage.dlex", jsonString);
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Output10.pdf");
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
	public static void SimpleDlexWithJsonString_AddDlex_Pdfoutput() {

		String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Pdf pdf = new Pdf();
		DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
		DlexInput input = pdf.addDlex(dlex, jsonString);
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Output11.pdf");
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
