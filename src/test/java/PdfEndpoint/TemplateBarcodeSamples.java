package PdfEndpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;

public class TemplateBarcodeSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void FilePathCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput1.pdf");
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
	public void bytesCode128Barcode_PdfOutput() {

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

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput89.pdf");
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
	public void streamCode128Barcode_PdfOutput() {

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

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput90.pdf");
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
	public void cloudRootCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput91.pdf");
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
	public void cloudSubFolderCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("Resources/DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput92.pdf");
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
	public void FilePathCode128BarcodeWithOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50,
				50, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput2.pdf");
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
	public void FilePathCode128BarcodeWithHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPLEFT, 50);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput3.pdf");
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
	public void FilePathCode128BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPRIGHT, 25);
		element.setColor(RgbColor.getRed());
		element.setXDimension(2);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput4.pdf");
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
	public void FilePathCode128BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.BOTTOMLEFT, 50);
		element.setShowText(true);
		element.setTextColor(RgbColor.getBlue());
		element.setFont(Font.getCourier());
		element.setFontSize(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput5.pdf");
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
	public void FilePathCode128BarcodeProcessTilde_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 ~ABarcode.", ElementPlacement.TOPCENTER,
				50);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput6.pdf");
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
	public void FilePathCode128BarcodeUccEan128_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		element.setUccEan128(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput7.pdf");
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
	public void filePathCode128BarcodePlacement_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		element.setPlacement(ElementPlacement.BOTTOMRIGHT);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput30.pdf");
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
	public void filePathCode128BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput31.pdf");
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
	public void filePathCode128BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput32.pdf");
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
	public void pageInputCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);
		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput33.pdf");
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
	public void pageInputWithTemplateCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput34.pdf");
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
	public void FilePathCode39Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput8.pdf");
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
	public void FilePathCode39BarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPLEFT, 40, 50, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput9.pdf");
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
	public void FilePathCode39BarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPCENTER, 50);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput10.pdf");
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
	public void FilePathCode39BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.BOTTOMCENTER, 50);
		element.setColor(RgbColor.getRed());
		element.setXDimension(1.5f);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput11.pdf");
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
	public void filePathCode39BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.BOTTOMCENTER, 50);
		element.setShowText(true);
		element.setTextColor(RgbColor.getRed());
		element.setFont(Font.getCourierBold());
		element.setFontSize(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput35.pdf");
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
	public void filePathCode39BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.BOTTOMLEFT, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput36.pdf");
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
	public void filePathCode39BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.BOTTOMLEFT, 50);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput37.pdf");
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
	public void pageInputCode39Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput38.pdf");
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
	public void pageInputTemplateCode39Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput39.pdf");
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
	public void filePathCode39BarcodeExtended_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);
		Template template = new Template("Temp1");
		Code39BarcodeElement element = new Code39BarcodeElement("Code 39", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput40.pdf");
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
	public void FilePathCode25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput12.pdf");
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
	public void FilePathCode25BarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPLEFT, 50, 50, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput13.pdf");
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
	public void FilePathCode25BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setTextColor(RgbColor.getRed());
		element.setFont(Font.getCourierBoldOblique());
		element.setFontSize(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput14.pdf");
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
	public void filePathCode25BarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 25);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput41.pdf");
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
	public void filePathCode25BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setColor(RgbColor.getRed());
		element.setXDimension(1.5f);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput42.pdf");
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
	public void filePathCode25BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput43.pdf");
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
	public void filePathCode25BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput44.pdf");
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
	public void pageInputCode25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput45.pdf");
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
	public void pageInputTemplateCode25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput46.pdf");
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
	public void FilePathCode93Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput15.pdf");
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
	public void FilePathCode93BarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPLEFT, 40, 50, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput16.pdf");
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
	public void FilePathCode93BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		element.setShowText(true);
		element.setTextColor(RgbColor.getRed());
		element.setFont(Font.getTimesBoldItalic());
		element.setFontSize(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput17.pdf");
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
	public void filePathCode93BarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput47.pdf");
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
	public void filePathCode93BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.BOTTOMCENTER, 50);
		element.setColor(new WebColor("#FF0000"));
		element.setXDimension(2);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput48.pdf");
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
	public void filePathCode93BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput49.pdf");
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
	public void filePathCode93BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput50.pdf");
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
	public void filePathCode93BarcodeExtended_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("Code 93", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput51.pdf");
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
	public void pageInputCode93Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput52.pdf");
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
	public void pageInputTemplateCode93Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput53.pdf");
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
	public void FilePathCode11Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput18.pdf");
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
	public void filePathCode11BarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPLEFT, 50, 10, 20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput19.pdf");
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
	public void FilePathCode11BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.BOTTOMRIGHT, 40);
		element.setShowText(true);
		element.setTextColor(RgbColor.getRed());
		element.setFont(Font.getHelveticaOblique());
		element.setFontSize(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput20.pdf");
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
	public void filePathCode11BarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		element.setHeight(60);
		element.setXOffset(20);
		element.setYOffset(20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput54.pdf");
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
	public void filePathCode11BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.BOTTOMLEFT, 25);
		element.setColor(RgbColor.getGreen());
		element.setXDimension(3);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput55.pdf");
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
	public void filePathCode11BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput56.pdf");
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
	public void filePathCode11BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput57.pdf");
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
	public void pageInputCode11Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput58.pdf");
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
	public void pageInputTemplateCode11Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput59.pdf");
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
	public void FilePathGs1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,
				Gs1DataBarType.OMNIDIRECTIONAL);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput21.pdf");
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
	public void FilePathGs1DataBarBarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPLEFT, 50,
				Gs1DataBarType.OMNIDIRECTIONAL, 50, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput22.pdf");
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
	public void FilePathGs1DataBarBarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 40,
				Gs1DataBarType.OMNIDIRECTIONAL);
		element.setShowText(true);
		element.setTextColor(RgbColor.getRed());
		element.setFontSize(10);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput23.pdf");
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
	public void filePathGs1DataBarBarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 10,
				Gs1DataBarType.EXPANDED);
		element.setHeight(50);
		element.setXOffset(0);
		element.setYOffset(100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput60.pdf");
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
	public void filePathGs1DataBarBarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.BOTTOMLEFT, 60,
				Gs1DataBarType.LIMITED);
		element.setColor(new WebColor("#02F1A5"));
		element.setXDimension(1.4f);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput61.pdf");
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
	public void filePathGs1DataBarBarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,
				Gs1DataBarType.OMNIDIRECTIONAL);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput62.pdf");
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
	public void filePathGs1DataBarBarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,
				Gs1DataBarType.OMNIDIRECTIONAL);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput63.pdf");
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
	public void pageInputGs1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,
				Gs1DataBarType.OMNIDIRECTIONAL);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput64.pdf");
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
	public void pageInputTamplateGs1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,
				Gs1DataBarType.EXPANDED);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput65.pdf");
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
	public void FilePathStackedGS1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 25);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput24.pdf");
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
	public void FilePathStackedGS1DataBarBarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 20, 10, 10);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput25.pdf");
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
	public void filePathStackedGS1DataBarBarcodeRowheightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPLEFT, StackedGs1DataBarType.EXPANDEDSTACKED, 50);
		element.setRowHeight(60);
		element.setXOffset(10);
		element.setYOffset(20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput66.pdf");
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
	public void filePathStackedGS1DataBarBarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKEDOMNIDIRECTIONAL, 30);
		element.setColor(RgbColor.getMaroon());
		element.setXDimension(1);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput67.pdf");
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
	public void filePathStackedGS1DataBarBarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.BOTTOMCENTER, StackedGs1DataBarType.STACKED, 20);
		element.setShowText(true);
		element.setTextColor(RgbColor.getGold());
		element.setFont(Font.getHelveticaBold());
		element.setFontSize(14);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput68.pdf");
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
	public void filePathStackedGS1DataBarBarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKEDOMNIDIRECTIONAL, 30);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput69.pdf");
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
	public void filePathStackedGS1DataBarBarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKEDOMNIDIRECTIONAL, 30);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput70.pdf");
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
	public void pageInputStackedGS1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 25);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput71.pdf");
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
	public void pageInputTemplateStackedGS1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 50);
		element.setExpandedStackedSegmentCount(6);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput72.pdf");
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
	public void FilePathIata25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput26.pdf");
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
	public void FilePathIata25BarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50, 10, 20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput27.pdf");
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
	public void filePathIata25BarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		element.setTextColor(RgbColor.getPink());
		Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\aial.ttf");
		element.setFont(font);
		element.setFontSize(11);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput73.pdf");
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
	public void filePathIata25BarcodeHeightXY_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPLEFT, 50);
		element.setHeight(60);
		element.setXOffset(10);
		element.setYOffset(15);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput74.pdf");
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
	public void filePathIata25BarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.BOTTOMRIGHT, 30);
		element.setColor(RgbColor.getYellow());
		element.setXDimension(3);
		element.setShowText(false);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput75.pdf");
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
	public void filePathIata25BarcodeIncludeCheckDigit_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		element.setIncludeCheckDigit(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput76.pdf");
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
	public void filePathIata25BarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.BOTTOMRIGHT, 30);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput77.pdf");
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
	public void filePathIata25BarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.BOTTOMRIGHT, 30);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput78.pdf");
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
	public void pageInputIata25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput79.pdf");
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
	public void pageInputWithTemplateIata25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput80.pdf");
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
	public void FilePathMsiBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput28.pdf");
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
	public void FilePathMsiBarcodeOptionalParameter_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPLEFT, 70, 20, 20);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput29.pdf");
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
	public void filePathMsiBarcodeHeightXYAppendcheckdigit_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 30);
		element.setHeight(60);
		element.setXOffset(20);
		element.setYOffset(20);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.MOD11);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput81.pdf");
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
	public void filePathMsiBarcodeColorXdimension_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.BOTTOMRIGHT, 40);
		element.setColor(RgbColor.getViolet());
		element.setXDimension(2);
		element.setShowText(false);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.MOD1010);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput82.pdf");
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
	public void filePathMsiBarcodeTextProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setTextColor(RgbColor.getAqua());
		element.setFont(Font.getTimesItalic());
		element.setFontSize(10);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput83.pdf");
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
	public void filePathMsiBarcodeAppendCheckDigit_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.MOD1110);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput84.pdf");
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
	public void filePathMsiBarcodeEvenPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 30);
		element.setEvenPages(true);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.MOD10);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput85.pdf");
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
	public void filePathMsiBarcodeOddPages_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 30);
		element.setOddPages(true);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.NONE);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput86.pdf");
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
	public void pageInputMsiBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput87.pdf");
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
	public void pageInputWithTemplateMsiBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		template.getElements().add(element);

		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\Template1DBarcodeOutput88.pdf");
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
	public void FilePathInputAztecBarcode_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput30.pdf");
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
	public void FilePathAztecBarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.BOTTOMRIGHT);
		element.setSymbolSize(AztecSymbolSize.R105XC105);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setProcessTilde(true);
        element.setReaderInitializationSymbol(true);
        element.setValue("test123");
        element.setXOffset(-100);
        element.setYOffset(-100);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput31.pdf");
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
	public void FilePathDataMatrixBarcodeElement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput76.pdf");
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
	public void FilePathDataMatrixBarcodeElementEnums_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 0, 0, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.ASCII, DataMatrixFunctionCharacter.NONE);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput32.pdf");
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
	public void FilePathDataMatrixBarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 0, 0, DataMatrixSymbolSize.R132XC132, DataMatrixEncodingType.C40, DataMatrixFunctionCharacter.MACRO05);
		element.setProcessTilde(true);
        element.setXDimension(5);
        element.setXOffset(50);
        element.setYOffset(50);
        element.setColor(RgbColor.getYellow());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput33.pdf");
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
	public void FilePathPdf417BarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
        element.setColor(RgbColor.getRed());
        element.setCompaction(Compaction.BYTE);
        element.setCompactPdf417(true);
        element.setErrorCorrection(ErrorCorrection.LEVEL6);
        element.setEvenPages(true);
        element.setPlacement(ElementPlacement.TOPRIGHT);
        element.setProcessTilde(true);
        element.setXDimension(4);
        element.setYDimension(5);
        element.setXOffset(-50);
        element.setYOffset(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput34.pdf");
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
	public void FilePathPdf417BarcodeElement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		 Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 3, 0, 0);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput35.pdf");
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
	public void FilePathQrcodeBarcodeElement_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPLEFT);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput36.pdf");
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
	public void FilePathQrcodeBarcodeElementProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50);
		element.setColor(RgbColor.getOrange());
        element.setVersion(20);
        element.setFnc1(QrCodeFnc1.GS1);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput37.pdf");
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
	public void FilePathInputAztecBarcodeSize_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.FULL);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput38.pdf");
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
	public void FilePathAztecBarcodeElementError_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.COMPACT);
        element.setAztecErrorCorrection(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput39.pdf");
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
	public void FilePathAztecBarcodeElementTilde_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.R109XC109);
        element.setProcessTilde(true);
        element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput40.pdf");
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
	public void FilePathAztecBarcodeElementReader_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.R109XC109);
        element.setProcessTilde(true);
        element.setReaderInitializationSymbol(true);
        element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput41.pdf");
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
	public void FilePath_AztecBarcodeElementXDimension_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.R109XC109);
        element.setProcessTilde(true);
        element.setXDimension(3);
        element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput42.pdf");
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
	public void FilePathAztecBarcodeElementColor_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setSymbolSize(AztecSymbolSize.R125XC125);
        element.setXDimension(3);
        element.setColor(RgbColor.getBlue());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput43.pdf");
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
	public void BytesAztecBarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT, 50,100);
		element.setSymbolSize(AztecSymbolSize.R125XC125);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setReaderInitializationSymbol(false);
        element.setValue("test123");
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput44.pdf");
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
	public void StreamAztecBarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT, 50,100);
		element.setSymbolSize(AztecSymbolSize.R125XC125);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setReaderInitializationSymbol(false);
        element.setValue("test123");
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput45.pdf");
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
	public void CloudRootAztecBarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PdfInput input = new PdfInput("DocumentA100.pdf");
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT, 100,100);
		element.setSymbolSize(AztecSymbolSize.R15XC15COMPACT);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setReaderInitializationSymbol(false);
        element.setValue("test123");
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput46.pdf");
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
	public void PageInputAztecBarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT, 100,100);
		element.setSymbolSize(AztecSymbolSize.R23XC23COMPACT);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setReaderInitializationSymbol(false);
        element.setValue("test123");
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput47.pdf");
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
	public void PageInputAztecBarcodeElementPropertiesAddedToPage_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		AztecBarcodeElement element = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT, 100,100);
		element.setSymbolSize(AztecSymbolSize.R27XC27);
        element.setXDimension(3);
        element.setColor(RgbColor.getRed());
        element.setAztecErrorCorrection(30);
        element.setReaderInitializationSymbol(false);
        element.setValue("test123");
        input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput48.pdf");
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
	public void FilePathAztecBarcodeElementPageByteArray_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		byte[] value = null;
		try {
			value = "Hello World".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AztecBarcodeElement element = new AztecBarcodeElement(value, ElementPlacement.TOPCENTER);
        element.setColor(RgbColor.getGreen());
        element.setAztecErrorCorrection(45);
        element.setSymbolSize(AztecSymbolSize.FULL);
        element.setReaderInitializationSymbol(false);
        element.setProcessTilde(true);
        input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateAztecBarcodeOutput49.pdf");
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
	public void FilePathDataMatrixBarcodeElementXDimension_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setXDimension(2);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput50.pdf");
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
	public void FilePathDataMatrixBarcodeElementColor_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER);
		element.setColor(RgbColor.getIndigo());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput51.pdf");
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
	public void FilePathDataMatrixBarcodeElementPlacement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, -50, 50);
		element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput52.pdf");
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
	public void FilePathDataMatrixBarcodeElementTilde_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput53.pdf");
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
	public void FilePathDataMatrixBarcodeElementSymbolSize_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.R120XC120);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput54.pdf");
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
	public void FilePathDataMatrixBarcodeElementEncodingType_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.BASE256);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput55.pdf");
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
	public void FilePathDataMatrixBarcodeElementFucntionChar_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.AUTO, DataMatrixEncodingType.AUTO, DataMatrixFunctionCharacter.FNC1);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput56.pdf");
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
	public void BytesDataMatrixBarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.R132XC132, DataMatrixEncodingType.C40, DataMatrixFunctionCharacter.MACRO05);
		element.setProcessTilde(true);
		element.setXDimension(5);
        element.setXOffset(50);
        element.setYOffset(50);
        element.setColor(RgbColor.getYellow());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput57.pdf");
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
	public void StreamDataMatrixBarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.R132XC132, DataMatrixEncodingType.C40, DataMatrixFunctionCharacter.MACRO05);
		element.setProcessTilde(true);
		element.setXDimension(5);
        element.setXOffset(50);
        element.setYOffset(50);
        element.setColor(RgbColor.getYellow());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput58.pdf");
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
	public void CloudRootDataMatrixBarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50, DataMatrixSymbolSize.R132XC132, DataMatrixEncodingType.C40, DataMatrixFunctionCharacter.MACRO05);
		element.setProcessTilde(true);
		element.setXDimension(5);
        element.setXOffset(50);
        element.setYOffset(50);
        element.setColor(RgbColor.getYellow());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput59.pdf");
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
	public void FilePathDataMatrixBarcodeElementPageByteArray_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		byte[] value = null;
		try {
			value = "Hello World".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement(value, ElementPlacement.TOPCENTER);
        element.setColor(RgbColor.getGreen());
        element.setProcessTilde(true);
        input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateDataMatrixBarcodeOutput60.pdf");
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
	public void FilePathPdf417BarcodeElementTilde_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 3);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput61.pdf");
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
	public void FilePathPdf417BarcodeElementCompaction_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 3);
		element.setCompaction(Compaction.AUTO);
		element.setProcessTilde(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput62.pdf");
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
	public void FilePathPdf417BarcodeElementErrorCorrection_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
		element.setErrorCorrection(ErrorCorrection.LEVEL2);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput75.pdf");
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
	public void FilePathPdf417BarcodeElementCompactPdf417_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
		element.setCompactPdf417(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput63.pdf");
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
	public void FilePathPdf417BarcodeElementYDimension_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
		element.setYDimension(3);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput64.pdf");
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
	public void StreamPdf417BarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
        element.setColor(RgbColor.getRed());
        element.setCompaction(Compaction.BYTE);
        element.setCompactPdf417(true);
        element.setErrorCorrection(ErrorCorrection.LEVEL6);
        element.setEvenPages(true);
        element.setPlacement(ElementPlacement.TOPRIGHT);
        element.setProcessTilde(true);
        element.setXDimension(4);
        element.setYDimension(5);
        element.setXOffset(-50);
        element.setYOffset(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput65.pdf");
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
	public void BytesPdf417BarcodeElementProperties_Pdfoutput() {

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

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
        element.setColor(RgbColor.getRed());
        element.setCompaction(Compaction.BYTE);
        element.setCompactPdf417(true);
        element.setErrorCorrection(ErrorCorrection.LEVEL6);
        element.setEvenPages(true);
        element.setPlacement(ElementPlacement.TOPRIGHT);
        element.setProcessTilde(true);
        element.setXDimension(4);
        element.setYDimension(5);
        element.setXOffset(-50);
        element.setYOffset(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput66.pdf");
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
	public void CloudRootPdf417BarcodeElementProperties_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
        element.setColor(RgbColor.getRed());
        element.setCompaction(Compaction.BYTE);
        element.setCompactPdf417(true);
        element.setErrorCorrection(ErrorCorrection.LEVEL6);
        element.setEvenPages(true);
        element.setPlacement(ElementPlacement.TOPRIGHT);
        element.setProcessTilde(true);
        element.setXDimension(4);
        element.setYDimension(5);
        element.setXOffset(-50);
        element.setYOffset(50);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput67.pdf");
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
	public void FilePathPdf417BarcodeElementByteArray_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		byte[] value = null;
		try {
			value = "Hello World".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Pdf417BarcodeElement element = new Pdf417BarcodeElement(value, ElementPlacement.TOPLEFT, 2);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplatePdf417BarcodeOutput68.pdf");
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
	public void FilePathQrcodeBarcodeElementVersion_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPLEFT);
		element.setVersion(25);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput69.pdf");
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
	public void FilePathQrcodeBarcodeElementFnc1_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPLEFT);
		element.setFnc1(QrCodeFnc1.INDUSTRY);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput70.pdf");
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
	public void BytesQrcodeBarcodeElementProperties_PdfOutput() {

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

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50);
		element.setColor(RgbColor.getOrange());
        element.setVersion(20);
        element.setFnc1(QrCodeFnc1.GS1);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput71.pdf");
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
	public void StreamQrcodeBarcodeElementProperties_PdfOutput() {

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

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50);
		element.setColor(RgbColor.getOrange());
        element.setVersion(20);
        element.setFnc1(QrCodeFnc1.GS1);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput72.pdf");
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
	public void CloudRootQrcodeBarcodeElementProperties_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		QrCodeElement element = new QrCodeElement("Hello World", ElementPlacement.TOPCENTER, 50, 50);
		element.setColor(RgbColor.getOrange());
        element.setVersion(20);
        element.setFnc1(QrCodeFnc1.GS1);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput74.pdf");
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
	public void FilePathQrcodeBarcodeElementByteArray_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("DocumentA100.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		byte[] value = null;
		try {
			value = "Hello World".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		QrCodeElement element = new QrCodeElement(value, ElementPlacement.TOPCENTER, 50, 50);
		element.setColor(RgbColor.getOrange());
        element.setVersion(20);
        element.setFnc1(QrCodeFnc1.GS1);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("C:\\Data\\outputs\\TemplateQrcodeBarcodeOutput73.pdf");
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
