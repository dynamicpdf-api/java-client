package PdfEndpoint;

import static org.testng.Assert.assertEquals;

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

		DlexResource dlex = new DlexResource("src\\test\\resources\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\SimpleReportData.json");
		DlexInput input = new DlexInput(dlex, layoutData);
		pdf.addAdditionalResource("src\\test\\resources\\Northwind Logo.gif");
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexInputSimple.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	
	@Test
	public void SimpleDlex_CloudData_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

        String jsonString = null;
		
		try {
			jsonString = Files.readString(Paths.get("src\\test\\resources\\SimpleReportData.json"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DlexInput input = new DlexInput("TFWResources/SimpleReportWithCoverPage.dlex", jsonString);
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexInputCloudData.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public void Template_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\SimpleReportWithCoverPage.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\SimpleReportData.json");
		DlexInput input = new DlexInput(dlex, layoutData);
		pdf.addAdditionalResource("src\\test\\resources\\Northwind Logo.gif");
		Template template = new Template("temp1");
        TextElement textElement = new TextElement("HelloWorld", ElementPlacement.TOPRIGHT);
        textElement.setYOffset(-40);
        template.getElements().add(textElement);
        input.setTemplate(template);
        
		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\DlexInputWithTemplate.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void ImageURI_Pdfoutput() {
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		DlexResource dlex = new DlexResource("src\\test\\resources\\dynamic-image.dlex");
		LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\ImageData.json");
		DlexInput input = pdf.addDlex(dlex, layoutData);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\ImageURI.pdf");
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
