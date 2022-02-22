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

public class TemplatePagenumberingSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void FilePathInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		Font fontResource = Font.fromFile("src\\test\\resources\\DejaVuSans.ttf", "DvsFont");

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setFont(fontResource);
		element.setFontSize(14.0f);
		element.setColor(RgbColor.getRed());
		template.getElements().add(element);
		input.setTemplate(template);

		pdf.getInputs().add(input);
		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplatePagenumberingSample.pdf");
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
	public void FilePathPNEsWithTokens_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\Emptypages.pdf");
		PdfInput emptypages = new PdfInput(pdfResource);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topLeftElement = new PageNumberingElement("%%CP(1)%% of %%TP%%", ElementPlacement.TOPLEFT);
		topLeftElement.setEvenPages(true);
		templateA.getElements().add(topLeftElement);

		PageNumberingElement topCenterElement = new PageNumberingElement("%%SP(I)%% of %%ST%%",
				ElementPlacement.TOPCENTER);
		topCenterElement.setOddPages(true);
		templateA.getElements().add(topCenterElement);

		PageNumberingElement topRightElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT);
		topRightElement.setEvenPages(true);
		templateA.getElements().add(topRightElement);

		PageNumberingElement bottomLeftElement = new PageNumberingElement("%%CP(I)%% of %%TP%%",
				ElementPlacement.BOTTOMLEFT);
		bottomLeftElement.setOddPages(true);
		templateA.getElements().add(bottomLeftElement);

		PageNumberingElement bottomCenterElement = new PageNumberingElement("%%CP(b)%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER);
		bottomCenterElement.setEvenPages(true);
		templateA.getElements().add(bottomCenterElement);

		PageNumberingElement bottomRightElement = new PageNumberingElement("%%CP(a)%% of %%TP%%",
				ElementPlacement.BOTTOMRIGHT);
		bottomRightElement.setOddPages(true);
		templateA.getElements().add(bottomRightElement);

		emptypages.setTemplate(templateA);

		pdf.getInputs().add(emptypages);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplatePagenumberingWithTokens.pdf");
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
