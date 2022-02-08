package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;

public class RectangleSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void pdfInput_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput1.pdf");
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
	public void pdfInputPlacement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setPlacement(ElementPlacement.TOPLEFT);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput2.pdf");
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
	public void pdfInputXYOffset_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPLEFT, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput3.pdf");
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
	public void pdfInputCornerRadius_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setCornerRadius(10);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput4.pdf");
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
	public void pdfInputtBorderWidth_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setBorderWidth(5);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput5.pdf");
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
	public void pdfInputBorderStyle_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setBorderStyle(LineStyle.getDots());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput6.pdf");
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
	public void pdfInputBorderColor_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setBorderColor(RgbColor.getBlue());
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput7.pdf");
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
	public void pdfInputFillColor_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setFillColor(RgbColor.getGreen());
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput8.pdf");
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
	public void pageInput_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput9.pdf");
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
	public void pageInput_AddRectangleToTemplate_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput input = new PageInput();

		Template template = new Template("Temp1");
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		template.getElements().add(element);

		input.setTemplate(template);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateRectangleOutput10.pdf");
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
