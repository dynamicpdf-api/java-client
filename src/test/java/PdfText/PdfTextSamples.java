package PdfText;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfContent;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfText;
import com.dynamicpdf.api.PdfTextResponse;
import com.dynamicpdf.api.TextOrder;

public class PdfTextSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		PdfText.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfText.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void TextExtraction()
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
	public void TextExtractionWithSinglePage()
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
	public void TextExtractionWithMultipage()
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

	@Test
	public void TextExtractionWithStream()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\HARDWARE_SPEC_2025-04-23a.pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(2);
		text.setPageCount(1);
		text.setTextOrder(TextOrder.Stream);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtractionWithStream.json");
			try {
				FileWriter fw=new FileWriter(file); 
				List<PdfContent> Content = response.getContent();
				fw.write(Content.get(0).getText());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void TextExtractionWithVisible()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\HARDWARE_SPEC_2025-04-23a.pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(2);
		text.setPageCount(1);
		text.setTextOrder(TextOrder.Visible);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtractionWithVisible.json");
			try {
				FileWriter fw=new FileWriter(file); 
				List<PdfContent> Content = response.getContent();
				fw.write(Content.get(0).getText());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void TextExtractionWithVisibleExtraSpace()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\HARDWARE_SPEC_2025-04-23a.pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(2);
		text.setPageCount(1);
		text.setTextOrder(TextOrder.VisibleExtraSpace);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfTextExtractionWithVisibleExtraSpace.json");
			try {
				FileWriter fw=new FileWriter(file); 
				List<PdfContent> Content = response.getContent();
				fw.write(Content.get(0).getText());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}
