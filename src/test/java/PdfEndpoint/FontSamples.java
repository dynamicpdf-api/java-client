package PdfEndpoint;

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
import com.dynamicpdf.api.elements.*;

public class FontSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void pdfInput_CoreFont_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(Font.getTimesBoldItalic());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput1.pdf");
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
	public void pdfInput_CoreFonts_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		
		TextElement element = new TextElement("Hello World (HelveticaBold)", ElementPlacement.TOPCENTER);
        element.setFont(Font.getHelveticaBold());
        template.getElements().add(element);

        TextElement element1 = new TextElement("Hello World (CourierBoldOblique)", ElementPlacement.TOPCENTER, 0, 100);
        element1.setFont(Font.getCourierBoldOblique());
        template.getElements().add(element1);

        TextElement element2 = new TextElement("#&%() +0123", ElementPlacement.TOPCENTER, 0, 200);
        element2.setFont(Font.getSymbol());
        template.getElements().add(element2);
		
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput12.pdf");
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
	public void pdfInput_OtfFont_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\Calibri.otf");

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput2.pdf");
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
	public void pdfInput_TtfFont_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\arialbi.ttf", "arialbi");

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput3.pdf");
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
	public void pdfInput_Embed_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
		font.setEmbed(false);

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput6.pdf");
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
	public void pdfInput_Subset_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
		font.setSubset(false);

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput7.pdf");
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
	public void pdfInput_EmbedSubset_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
		font.setEmbed(true);
		font.setSubset(false);

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput8.pdf");
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
	public void pdfInput_SubsetEmbed_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
        font.setSubset(true);
		font.setEmbed(false);

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput9.pdf");
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
	public void pdfInput_FontFromSystem_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromSystem("Arial Black");

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput4.pdf");
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
	public void pdfInput_FontFromSystemResourcename_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		Font font = Font.fromSystem("Arial Black", "ArialBlk");

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput10.pdf");
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
	public void pdfInput_FontFromStream_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		
		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\ArialMTStd.otf");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Font font = Font.fromStream(targetStream);

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput5.pdf");
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
	public void pdfInput_FontFromStreamResourcename_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		
		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\ArialMTStd.otf");
        InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Font font = Font.fromStream(targetStream, "ArialMTStd");

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateFontOutput11.pdf");
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
	public void pageInput_CloudRoot_Pdfoutput() {

		Pdf pdf = new Pdf();

		Font font = new Font("Calibri.otf");

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput12.pdf");
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
	public void pageInput_CloudSubFolder_Pdfoutput() {

		Pdf pdf = new Pdf();

		Font font = new Font("Resources/Calibri.otf");

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setFont(font);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput13.pdf");
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
	public void pageInput_MultipleFonts_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\arialbi.ttf");
		TextElement element = new TextElement("Hello World (arialbi)", ElementPlacement.TOPCENTER);
		element.setFont(font);
		pageInput.getElements().add(element);

		Font font1 = Font.fromFile("src\\test\\resources\\PdfEndpoint\\Calibri.otf");
		TextElement element1 = new TextElement("Hello World (Calibri)", ElementPlacement.TOPCENTER, 0, 100);
		element1.setFont(font1);
		pageInput.getElements().add(element1);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput14.pdf");
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
	public void pageInput_CoreFontsHelvetica_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World (Helvetica)", ElementPlacement.TOPCENTER);
		element.setFont(Font.getHelvetica());
		pageInput.getElements().add(element);

		TextElement element1 = new TextElement("Hello World (HelveticaBold)", ElementPlacement.TOPCENTER, 0, 100);
		element1.setFont(Font.getHelveticaBold());
		pageInput.getElements().add(element1);

		TextElement element2 = new TextElement("Hello World (HelveticaBoldOblique)", ElementPlacement.TOPCENTER, 0,
				200);
		element2.setFont(Font.getHelveticaBoldOblique());
		pageInput.getElements().add(element2);

		TextElement element3 = new TextElement("Hello World (HelveticaOblique)", ElementPlacement.TOPCENTER, 0, 300);
		element3.setFont(Font.getHelveticaOblique());
		pageInput.getElements().add(element3);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput15.pdf");
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
	public void pageInput_CoreFontsCourier_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World (Courier)", ElementPlacement.TOPCENTER);
		element.setFont(Font.getCourier());
		pageInput.getElements().add(element);

		TextElement element1 = new TextElement("Hello World (CourierBold)", ElementPlacement.TOPCENTER, 0, 100);
		element1.setFont(Font.getCourierBold());
		pageInput.getElements().add(element1);

		TextElement element2 = new TextElement("Hello World (CourierBoldOblique)", ElementPlacement.TOPCENTER, 0, 200);
		element2.setFont(Font.getCourierBoldOblique());
		pageInput.getElements().add(element2);

		TextElement element3 = new TextElement("Hello World (CourierOblique)", ElementPlacement.TOPCENTER, 0, 300);
		element3.setFont(Font.getCourierOblique());
		pageInput.getElements().add(element3);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput16.pdf");
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
	public void pageInput_CoreFontsTimesRoman_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("Hello World (TimesBold)", ElementPlacement.TOPCENTER);
		element.setFont(Font.getTimesBold());
		pageInput.getElements().add(element);

		TextElement element1 = new TextElement("Hello World (TimesBoldItalic)", ElementPlacement.TOPCENTER, 0, 100);
		element1.setFont(Font.getTimesBoldItalic());
		pageInput.getElements().add(element1);

		TextElement element2 = new TextElement("Hello World (TimesItalic)", ElementPlacement.TOPCENTER, 0, 200);
		element2.setFont(Font.getTimesItalic());
		pageInput.getElements().add(element2);

		TextElement element3 = new TextElement("Hello World (TimesRoman)", ElementPlacement.TOPCENTER, 0, 300);
		element3.setFont(Font.getTimesRoman());
		pageInput.getElements().add(element3);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput17.pdf");
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
	public void pageInput_CoreFontsSymbolAndZapfDingbats_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		TextElement element = new TextElement("ABCDEF abcdef", ElementPlacement.TOPCENTER);
		element.setFont(Font.getZapfDingbats());
		pageInput.getElements().add(element);

		TextElement element1 = new TextElement("#&%() +0123", ElementPlacement.TOPCENTER, 0, 100);
		element1.setFont(Font.getSymbol());
		pageInput.getElements().add(element1);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\FontOutput18.pdf");
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
