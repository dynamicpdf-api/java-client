package PdfText;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;

public class PdfTextSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		PdfText.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfText.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public static void TextExtraction()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\TimeMachine.pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtraction.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public static void TextExtractionWithSinglePage()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\TimeMachine.pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(5);
		text.setPageCount(1);

		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtractionWithSinglePage.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

	@Test
	public static void TextExtractionWithMultipage()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\TimeMachine.pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(2);
		text.setPageCount(3);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtractionWithMultipage.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}

}
