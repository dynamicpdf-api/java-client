package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;

public class LineSample {

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
		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 20, 20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput1.pdf");
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
	public void pdfInputLineStyle_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		element.setLineStyle(new LineStyle(new float[] { 2, 4, 2, }, 0.5f));
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput2.pdf");
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

		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		element.setXOffset(100);
		element.setYOffset(100);
		element.setLineStyle(LineStyle.getDash());

		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput3.pdf");
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
	public void pdfInputColor_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		element.setColor(RgbColor.getRed());
		element.setLineStyle(LineStyle.getDash());

		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput4.pdf");
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
	public void pdfInputProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");

		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		element.setColor(new RgbColor(0, 0, 1));
		element.setXOffset(100);
		element.setYOffset(100);
		element.setLineStyle(LineStyle.getDashLarge());
		element.setWidth(4);

		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput5.pdf");
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

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		LineElement element = new LineElement(ElementPlacement.BOTTOMRIGHT, 20, 20);
		input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput6.pdf");
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
	public void pageInputXYOffset_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		element.setXOffset(100);
		element.setYOffset(100);
		element.setLineStyle(LineStyle.getDash());
		input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput7.pdf");
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
	public void pageInput_AddLineToTemplate_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
		template.getElements().add(element);

		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateLineOutput8.pdf");
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
