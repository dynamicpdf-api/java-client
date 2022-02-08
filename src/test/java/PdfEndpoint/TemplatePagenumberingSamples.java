package PdfEndpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	public void filePathInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput1.pdf");
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
	public void streamInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(targetStream);
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput5.pdf");
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
	public void bytesInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput6.pdf");
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
	public void cloudRootInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput7.pdf");
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
	public void cloudSubFolderInputPNE_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput8.pdf");
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
	public void FilePathInputPNEWithProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template template = new Template("Temp1");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER, 50, 50);
		element.setFont(fontResource);
		element.setFontSize(14.0f);
		element.setColor(RgbColor.getRed());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput2.pdf");
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
	public void filePathInputPNEs_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput9.pdf");
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
	public void streamInputPNEs_PdfOutput() {

		Pdf pdf = new Pdf();

		File invoiceFile = new File("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		InputStream invoiceStream = null;
		try {
			invoiceStream = new FileInputStream(invoiceFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource invoiceResource = new PdfResource(invoiceStream);
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		File fw9AcroFormFile = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		InputStream fw9AcroFormStream = null;
		try {
			fw9AcroFormStream = new FileInputStream(fw9AcroFormFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource fw9AcroForm_18Resource = new PdfResource(fw9AcroFormStream);
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		File documentA100File = new File("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		InputStream documentA100Stream = null;
		try {
			documentA100Stream = new FileInputStream(documentA100File);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource documentA100Resource = new PdfResource(documentA100Stream);
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput10.pdf");
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
	public void bytesInputPNEs_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array1 = null;
		try {
			array1 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Invoice.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource invoiceResource = new PdfResource(array1);
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		byte[] array2 = null;
		try {
			array2 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource fw9AcroForm_18Resource = new PdfResource(array2);
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		byte[] array3 = null;
		try {
			array3 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource documentA100Resource = new PdfResource(array3);
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput11.pdf");
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
	public void cloudRootInputPNEs_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput invoice = new PdfInput("Invoice.pdf");
		pdf.getInputs().add(invoice);

		PdfInput fw9AcroForm_18 = new PdfInput("fw9AcroForm_18.pdf");
		pdf.getInputs().add(fw9AcroForm_18);

		PdfInput documentA100 = new PdfInput("DocumentA100.pdf");
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput12.pdf");
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
	public void cloudSubFolderInputPNEs_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput invoice = new PdfInput("Resources/Invoice.pdf");
		pdf.getInputs().add(invoice);

		PdfInput fw9AcroForm_18 = new PdfInput("Resources/fw9AcroForm_18.pdf");
		pdf.getInputs().add(fw9AcroForm_18);

		PdfInput documentA100 = new PdfInput("Resources/DocumentA100.pdf");
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput13.pdf");
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
	public void filePathPNEWithProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template templateA = new Template("TemplateA");
		PageNumberingElement topElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER, 50,
				50);
		topElement.setFont(fontResource);
		topElement.setFontSize(14.0f);
		topElement.setColor(RgbColor.getRed());
		templateA.getElements().add(topElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER, 50, -50);
		bottomElement.setFontSize(14.0f);
		bottomElement.setColor(RgbColor.getRed());
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput14.pdf");
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
	public void FilePathPNEsWithTokens_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
		PdfInput emptypages = new PdfInput(pdfResource);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topLeftElement = new PageNumberingElement("%%CP(1)%% of %%TP%%", ElementPlacement.TOPLEFT);
		templateA.getElements().add(topLeftElement);

		PageNumberingElement topCenterElement = new PageNumberingElement("%%SP(I)%% of %%ST%%",
				ElementPlacement.TOPCENTER);
		templateA.getElements().add(topCenterElement);

		PageNumberingElement topRightElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT);
		templateA.getElements().add(topRightElement);

		PageNumberingElement bottomLeftElement = new PageNumberingElement("%%CP(I)%% of %%TP%%",
				ElementPlacement.BOTTOMLEFT);
		templateA.getElements().add(bottomLeftElement);

		PageNumberingElement bottomCenterElement = new PageNumberingElement("%%CP(b)%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER);
		templateA.getElements().add(bottomCenterElement);

		PageNumberingElement bottomRightElement = new PageNumberingElement("%%CP(a)%% of %%TP%%",
				ElementPlacement.BOTTOMRIGHT);
		templateA.getElements().add(bottomRightElement);

		emptypages.setTemplate(templateA);

		pdf.getInputs().add(emptypages);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput3.pdf");
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
	public void FilePath_PNEsWithTokensAndProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
		PdfInput emptypages = new PdfInput(pdfResource);
		Template templateA = new Template("TemplateA");

		PageNumberingElement topLeftElement = new PageNumberingElement("%%CP(1)%% of %%TP%%", ElementPlacement.TOPLEFT,
				50, 50);
		topLeftElement.setFont(Font.getCourier());
		topLeftElement.setFontSize(14.0f);
		templateA.getElements().add(topLeftElement);

		PageNumberingElement topCenterElement = new PageNumberingElement("%%SP(I)%% of %%ST%%",
				ElementPlacement.TOPCENTER, 50, 50);
		topCenterElement.setFont(Font.getCourier());
		topCenterElement.setFontSize(14.0f);
		templateA.getElements().add(topCenterElement);

		PageNumberingElement topRightElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT, -50, 50);
		topRightElement.setFont(Font.getCourier());
		topRightElement.setFontSize(14.0f);
		templateA.getElements().add(topRightElement);

		PageNumberingElement bottomLeftElement = new PageNumberingElement("%%CP(I)%% of %%TP%%",
				ElementPlacement.BOTTOMLEFT, 50, -50);
		bottomLeftElement.setFont(Font.getCourier());
		bottomLeftElement.setFontSize(14.0f);
		templateA.getElements().add(bottomLeftElement);

		PageNumberingElement bottomCenterElement = new PageNumberingElement("%%CP(b)%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER, 50, -50);
		bottomCenterElement.setFont(Font.getCourier());
		bottomCenterElement.setFontSize(14.0f);
		templateA.getElements().add(bottomCenterElement);

		PageNumberingElement bottomRightElement = new PageNumberingElement("%%CP(a)%% of %%TP%%",
				ElementPlacement.BOTTOMRIGHT, -50, -50);
		bottomRightElement.setFont(Font.getCourier());
		bottomRightElement.setFontSize(14.0f);
		templateA.getElements().add(bottomRightElement);

		emptypages.setTemplate(templateA);

		pdf.getInputs().add(emptypages);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput4.pdf");
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
	public void filePath_PNEsWithTokens_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement topLeftElement = new PageNumberingElement("%%CP(1)%% of %%TP%%", ElementPlacement.TOPLEFT);
		templateA.getElements().add(topLeftElement);

		PageNumberingElement topCenterElement = new PageNumberingElement("%%SP(I)%% of %%ST%%",
				ElementPlacement.TOPCENTER);
		templateA.getElements().add(topCenterElement);

		PageNumberingElement topRightElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT);
		templateA.getElements().add(topRightElement);

		PageNumberingElement bottomLeftElement = new PageNumberingElement("%%CP(I)%% of %%TP%%",
				ElementPlacement.BOTTOMLEFT);
		templateA.getElements().add(bottomLeftElement);

		PageNumberingElement bottomCenterElement = new PageNumberingElement("%%CP(b)%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER);
		templateA.getElements().add(bottomCenterElement);

		PageNumberingElement bottomRightElement = new PageNumberingElement("%%CP(a)%% of %%TP%%",
				ElementPlacement.BOTTOMRIGHT);
		templateA.getElements().add(bottomRightElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER);
		templateB.getElements().add(bottomElement);
		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput15.pdf");
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
	public void filePathPNEsWithTokensAndProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template templateA = new Template("TemplateA");
		PageNumberingElement topLeftElement = new PageNumberingElement("%%CP(1)%% of %%TP%%", ElementPlacement.TOPLEFT,
				50, 50);
		topLeftElement.setFont(fontResource);
		topLeftElement.setFontSize(14.0f);
		templateA.getElements().add(topLeftElement);

		PageNumberingElement topCenterElement = new PageNumberingElement("%%SP(I)%% of %%ST%%",
				ElementPlacement.TOPCENTER, 50, 50);
		topCenterElement.setFont(fontResource);
		topCenterElement.setFontSize(14.0f);
		templateA.getElements().add(topCenterElement);

		PageNumberingElement topRightElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT, -50, 50);
		topRightElement.setFont(fontResource);
		topRightElement.setFontSize(14.0f);
		templateA.getElements().add(topRightElement);

		PageNumberingElement bottomLeftElement = new PageNumberingElement("%%CP(I)%% of %%TP%%",
				ElementPlacement.BOTTOMLEFT, 50, -50);
		bottomLeftElement.setFont(fontResource);
		bottomLeftElement.setFontSize(14.0f);
		templateA.getElements().add(bottomLeftElement);

		PageNumberingElement bottomCenterElement = new PageNumberingElement("%%CP(b)%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER, 50, -50);
		bottomCenterElement.setFont(fontResource);
		bottomCenterElement.setFontSize(14.0f);
		templateA.getElements().add(bottomCenterElement);

		PageNumberingElement bottomRightElement = new PageNumberingElement("%%CP(a)%% of %%TP%%",
				ElementPlacement.BOTTOMRIGHT, -50, -50);
		bottomRightElement.setFont(fontResource);
		bottomRightElement.setFontSize(14.0f);
		templateA.getElements().add(bottomRightElement);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMCENTER, 50, -50);
		;
		bottomElement.setFont(fontResource);
		bottomElement.setFontSize(14.0f);
		bottomElement.setColor(RgbColor.getBlue());
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput16.pdf");
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
	public void filePath_PNEWithMultilineAndProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(pdfResource);
		pdf.getInputs().add(input);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% \r\nof %%TP%%", ElementPlacement.TOPCENTER, 50,
				50);
		element.setFont(fontResource);
		element.setFontSize(14.0f);
		templateA.getElements().add(element);

		input.setTemplate(templateA);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput17.pdf");
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
	public void filePathPNEAddedToEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(pdfResource);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setEvenPages(true);
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput18.pdf");
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
	public void stream_PNEAddedToEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource pdfResource = new PdfResource(targetStream);
		PdfInput input = new PdfInput(pdfResource);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setEvenPages(true);
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput19.pdf");
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
	public void bytes_PNEAddedToEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfResource pdfResource = new PdfResource(array);
		PdfInput input = new PdfInput(pdfResource);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setEvenPages(true);
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput20.pdf");
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
	public void cloudRootPNEAddedToEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setEvenPages(true);
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput21.pdf");
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
	public void cloudSubFolderPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/DocumentA100.pdf");

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
		element.setEvenPages(true);
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput22.pdf");
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
	public void filePathPNEWithPropertiesAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(pdfResource);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER, 50, 50);
		element.setFont(fontResource);
		element.setFontSize(14.0f);
		element.setEvenPages(true);
		element.setColor(RgbColor.getRed());
		templateA.getElements().add(element);
		input.setTemplate(templateA);

		pdf.getInputs().add(input);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput23.pdf");
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
	public void filePathPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
		element.setEvenPages(true);
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT);
		bottomElement.setOddPages(true);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput24.pdf");
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
	public void streamInputPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile1 = new File("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		InputStream targetStream1 = null;
		try {
			targetStream1 = new FileInputStream(initialFile1);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource invoiceResource = new PdfResource(targetStream1);
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		File initialFile2 = new File("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		InputStream targetStream2 = null;
		try {
			targetStream2 = new FileInputStream(initialFile2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource fw9AcroForm_18Resource = new PdfResource(targetStream2);
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		File initialFile3 = new File("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		InputStream targetStream3 = null;
		try {
			targetStream3 = new FileInputStream(initialFile3);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource documentA100Resource = new PdfResource(targetStream3);
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
		element.setEvenPages(true);
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT);
		bottomElement.setOddPages(true);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput25.pdf");
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
	public void bytesInputPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array1 = null;
		try {
			array1 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\Invoice.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource invoiceResource = new PdfResource(array1);
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		byte[] array2 = null;
		try {
			array2 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource fw9AcroForm_18Resource = new PdfResource(array2);
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		byte[] array3 = null;
		try {
			array3 = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource documentA100Resource = new PdfResource(array3);
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
		element.setEvenPages(true);
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT);
		bottomElement.setOddPages(true);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput26.pdf");
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
	public void cloudRootPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput invoice = new PdfInput("Invoice.pdf");
		pdf.getInputs().add(invoice);

		PdfInput fw9AcroForm_18 = new PdfInput("fw9AcroForm_18.pdf");
		pdf.getInputs().add(fw9AcroForm_18);

		PdfInput documentA100 = new PdfInput("DocumentA100.pdf");
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
		element.setEvenPages(true);
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT);
		bottomElement.setOddPages(true);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput27.pdf");
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
	public void coludSubFolderPNEAddedToEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput invoice = new PdfInput("Resources/Invoice.pdf");
		pdf.getInputs().add(invoice);

		PdfInput fw9AcroForm_18 = new PdfInput("Resources/fw9AcroForm_18.pdf");
		pdf.getInputs().add(fw9AcroForm_18);

		PdfInput documentA100 = new PdfInput("Resources/DocumentA100.pdf");
		pdf.getInputs().add(documentA100);

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
		element.setEvenPages(true);
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT);
		bottomElement.setOddPages(true);
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput28.pdf");
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
	public void filePathPNEWithPropertiesEO_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoice = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoice);

		PdfResource fw9AcroForm_18Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_18.pdf");
		PdfInput fw9AcroForm_18 = new PdfInput(fw9AcroForm_18Resource);
		pdf.getInputs().add(fw9AcroForm_18);

		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100 = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100);

		Font fontResource = Font.fromFile("src\\test\\resources\\PdfEndpoint\\ARIALNB.TTF", "arialfont");

		Template templateA = new Template("TemplateA");
		PageNumberingElement element = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT, -50, 50);
		element.setFont(fontResource);
		element.setFontSize(14.0f);
		element.setEvenPages(true);
		element.setColor(RgbColor.getRed());
		templateA.getElements().add(element);

		invoice.setTemplate(templateA);
		documentA100.setTemplate(templateA);

		Template templateB = new Template("TemplateB");
		PageNumberingElement bottomElement = new PageNumberingElement("%%CP%%", ElementPlacement.BOTTOMLEFT, 50, -50);
		bottomElement.setFont(fontResource);
		bottomElement.setFontSize(14.0f);
		bottomElement.setOddPages(true);
		bottomElement.setColor(RgbColor.getBlue());
		templateB.getElements().add(bottomElement);

		fw9AcroForm_18.setTemplate(templateB);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput29.pdf");
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
	public void pageInputTextAndImageAndPNEWithProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		// Add Blank Page
		PageInput pageInput = new PageInput();

		// Add element into the page
		TextElement element = new TextElement("Hello World1", ElementPlacement.TOPLEFT);
		element.setColor(RgbColor.getRed());
		pageInput.getElements().add(element);

		// Create template and add text element
		Template template = new Template("Temp1");
		TextElement element1 = new TextElement("Hello World", ElementPlacement.TOPCENTER);
		element.setColor(RgbColor.getBlue());
		template.getElements().add(element1);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		// Add Pdfinput
		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
		PdfInput invoicePdfInput = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoicePdfInput);

		// Create template and add pagenumbering element
		Template templateA = new Template("TemplateA");
		PageNumberingElement pageNumberingElement = new PageNumberingElement("%%CP%% of %%TP%%",
				ElementPlacement.TOPCENTER);
		templateA.getElements().add(pageNumberingElement);

		invoicePdfInput.setTemplate(templateA);

		// Add pdfinput
		PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput documentA100PdfInput = new PdfInput(documentA100Resource);
		pdf.getInputs().add(documentA100PdfInput);

		// create EvenAddTemplate with pagenumbering label
		Template templateB = new Template("TemplateB");
		PageNumberingElement pageNumberingElement1 = new PageNumberingElement("%%CP%%", ElementPlacement.TOPCENTER);
		pageNumberingElement1.setOddPages(true);
		templateB.getElements().add(pageNumberingElement1);

		documentA100PdfInput.setTemplate(templateB);

		// Add pdfinput

		PdfResource singlePageResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\SinglePage.pdf");
		PdfInput singlePagePdfInput = new PdfInput(singlePageResource);
		pdf.getInputs().add(singlePagePdfInput);

		PdfResource fw9AcroForm_14Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\fw9AcroForm_14.pdf");
		PdfInput fw9AcroForm_14PdfInput = new PdfInput(fw9AcroForm_14Resource);
		pdf.getInputs().add(fw9AcroForm_14PdfInput);

		// Add Blank Page
		PageInput pageInput1 = new PageInput();

		// Add element into the page
		TextElement element2 = new TextElement("Hello World1", ElementPlacement.TOPLEFT);
		pageInput1.getElements().add(element2);

		pdf.getInputs().add(pageInput1);

		ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
		ImageInput imageInput = new ImageInput(resource);
		pdf.getInputs().add(imageInput);
		imageInput.setAlign(Align.CENTER);
		imageInput.setVAlign(VAlign.CENTER);
		imageInput.setPageWidth(400);
		imageInput.setPageHeight(400);

		// create EvenAddTemplate with pagenumbering label
		Template templateC = new Template("TemplateC");
		PageNumberingElement pageNumberingElement2 = new PageNumberingElement("%%CP%% of %%TP%%",
				ElementPlacement.BOTTOMCENTER);
		templateC.getElements().add(pageNumberingElement2);

		imageInput.setTemplate(templateC);

		PdfResource emptyPageResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
		PdfInput emptyPagesPdfInput = new PdfInput(emptyPageResource);
		emptyPagesPdfInput.setTemplate(templateA);

		pdf.getInputs().add(emptyPagesPdfInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput30.pdf");
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
	public void filePathInputOtherTesting_PdfOutput() {

		Pdf pdf = new Pdf();

		// Add Pdfinput
		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\1000Pages.pdf");
		PdfInput invoicePdfInput = new PdfInput(invoiceResource);
		pdf.getInputs().add(invoicePdfInput);
		pdf.getInputs().add(invoicePdfInput);

		// Create template and add pagenumbering element
		Template templateA = new Template("TemplateA");
		PageNumberingElement pageNumberingElement = new PageNumberingElement("%%CP(i)%% of %%TP%%",
				ElementPlacement.TOPRIGHT);
		templateA.getElements().add(pageNumberingElement);

		invoicePdfInput.setTemplate(templateA);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePNLOutput31.pdf");
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
