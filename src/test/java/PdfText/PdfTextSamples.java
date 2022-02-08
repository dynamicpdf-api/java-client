package PdfText;

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
	public static void PdfTextSample()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\3PagesWithText.pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtraction()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\Test_Textmarker_Serienbrief(2).pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text1.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtractionWithSinglePage()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\Test_Textmarker_Serienbrief(2).pdf");

		PdfText text = new PdfText(resource);
		text.setStartPage(5);
		text.setPageCount(1);

		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text2.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtractionWithMultipage()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\Test_Textmarker_Serienbrief(2).pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text3.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtractionCJKFonts()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\pdf_font-zhcn.pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text4.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtractionSpecialChars()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\Input.pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text5.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void TextExtractionArabic()
	{



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfText\\Arabic.pdf");

		PdfText text = new PdfText(resource);
		PdfTextResponse response = text.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\text6.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

}
