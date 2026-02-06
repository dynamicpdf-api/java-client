package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;

public class FontSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void PageInput_CoreFont_Pdfoutput()
	{
		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(Font.getTimesBoldItalic());
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\CoreFont.pdf");
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
	public void PageInput_Font_Pdfoutput() 
	{
		Pdf pdf = new Pdf();

		Font font = Font.fromFile("src\\test\\resources\\DejaVuSans.ttf");
		font.setEmbed(true);
		font.setSubset(true);
		
		PageInput pageInput = new PageInput();
		
		TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        element.setFont(font);
        pageInput.getElements().add(element);
        
        pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\FontSample.pdf");
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
	public void PageInput_GoogleFont_Pdfoutput() {
		Pdf pdf = new Pdf();
		
		Font font = Font.google("roboto");
		font.setEmbed(true);
		font.setSubset(true);

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
		element.setFont(font);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\GoogleFont.pdf");
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
	public void PageInput_GlobalFont_Pdfoutput() {
		Pdf pdf = new Pdf();
		 
        Font font = Font.global("Paris Normal");
        
        font.setEmbed(true);
        
        font.setSubset(true);
        
        PageInput pageInput = new PageInput();
        
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        element.setFont(font);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\GlobalFont.pdf");
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
	public void PageInput_SystemFont_Pdfoutput() {
		Pdf pdf = new Pdf();

		Font font = Font.fromSystem("Monotype Corsiva", "Monotype Corsiva.ttf");

		font.setEmbed(true);

		font.setSubset(true);

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFontSize(20);
		element.setFont(font);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\SystemFont.pdf");
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
