package PdfEndpoint;

import static org.testng.Assert.assertEquals;

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

public class TemplateBarcodeSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	

	@Test
	public void PageInputAztecBarcodeElement_Pdfoutput() {

		Pdf pdf = new Pdf();
		
		PageInput input = new PageInput();
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
			File file = new File("src\\test\\outputs\\TemplateBarcodeAztec.pdf");
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
	public void FilePathDataMatrixBarcodeElement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\Emptypages.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		
		DataMatrixBarcodeElement element = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPRIGHT,0,0);
		element.setPlacement(ElementPlacement.TOPLEFT);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setXDimension(3);
		element.setProcessTilde(true);
		element.setColor(RgbColor.getYellow());
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeDataMatrix.pdf");
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
	public void CloudRootPdf417BarcodeElement_Pdfoutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("TFWResources/Emptypages.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Pdf417BarcodeElement element = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 2);
        element.setColor(RgbColor.getRed());
        element.setCompaction(Compaction.TEXT);
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
			File file = new File("src\\test\\outputs\\TemplateBarcodePdf417.pdf");
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
	public void StreamQrcodeBarcodeElement_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\Emptypages.pdf");
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
			File file = new File("src\\test\\outputs\\TemplateBarcodeQrCode.pdf");
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
	public void BytesCode128Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\Emptypages.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code128BarcodeElement element = new Code128BarcodeElement("Code 128 ~ABarcode.", ElementPlacement.TOPCENTER, 50);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		element.setColor(RgbColor.getRed());
		element.setXDimension(2);
		element.setTextColor(RgbColor.getBlue());
		element.setFont(Font.getCourier());
		element.setFontSize(15);
		element.setProcessTilde(true);
		element.setUccEan128(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeCode128.pdf");
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
	public void PageInputCode39Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code39BarcodeElement element = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPCENTER, 100, 50, 50);
		element.setXDimension(1.5f);
		element.setShowText(true);
		element.setTextColor(RgbColor.getRed());
		element.setFont(Font.getCourierBold());
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeCode39.pdf");
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
	public void BytesCode25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		byte[] array = null;
		try {
			array = Files.readAllBytes(Paths.get("src\\test\\resources\\Emptypages.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PdfResource resource = new PdfResource(array);
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Code25BarcodeElement element = new Code25BarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setHeight(80);
		element.setXOffset(100);
		element.setYOffset(100);
		element.setColor(RgbColor.getRed());
		element.setXDimension(1.5f);
		element.setShowText(true);
		element.setOddPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeCode25.pdf");
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
	public void PageInputCode93Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		Code93BarcodeElement element = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
		element.setHeight(60);
		element.setXOffset(100);
		element.setYOffset(100);
		element.setColor(new WebColor("#FF0000"));
		element.setXDimension(2);
		element.setShowText(false);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeCode93.pdf");
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
	public void StreamCode11Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		File initialFile = new File("src\\test\\resources\\Emptypages.pdf");
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
		Code11BarcodeElement element = new Code11BarcodeElement("12345678", ElementPlacement.BOTTOMLEFT,100, 10, 10);
		element.setXDimension(3);
        element.setYOffset(-50);
        element.setTextColor(RgbColor.getRed());
        element.setFont(Font.getHelveticaOblique());
        element.setFontSize(20);
        element.setEvenPages(true);
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeCode11.pdf");
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
	public void CloudSubFolderGs1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfInput input = new PdfInput("TFWResources/Emptypages.pdf");

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		Gs1DataBarBarcodeElement element = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, 50,Gs1DataBarType.OMNIDIRECTIONAL);
		element.setPlacement(ElementPlacement.BOTTOMCENTER);
		element.setXOffset(0);
        element.setYOffset(-100);
		element.setColor(new WebColor("#02F1A5"));    
        element.setXDimension(1.4f);
        
		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeGs1DataBar.pdf");
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
	public void PageInputStackedGS1DataBarBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		StackedGs1DataBarBarcodeElement element = new StackedGs1DataBarBarcodeElement("12345678",
				ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 25);
		element.setRowHeight(60);
		element.setXOffset(10);
		element.setYOffset(20);
		element.setColor(RgbColor.getMaroon());
		element.setXDimension(1);
		pageInput.getElements().add(element);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeStackedGs1DataBar.pdf");
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
	public void PageInputWithTemplateIata25Barcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();
		
		Template template = new Template("Temp1");
		Iata25BarcodeElement element = new Iata25BarcodeElement("12345678", ElementPlacement.TOPCENTER, 50, 100, 0);
		element.setHeight(60);
		element.setColor(RgbColor.getYellow());
		element.setXDimension(3);
		element.setTextColor(RgbColor.getPink());
		element.setIncludeCheckDigit(true);
		template.getElements().add(element);
		
		pageInput.setTemplate(template);

		pdf.getInputs().add(pageInput);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeIata25.pdf");
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
	public void FilePathMsiBarcode_PdfOutput() {

		Pdf pdf = new Pdf();

		PdfResource resource = new PdfResource("src\\test\\resources\\Emptypages.pdf");
		PdfInput input = new PdfInput(resource);

		pdf.getInputs().add(input);

		Template template = new Template("Temp1");
		MsiBarcodeElement element = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
		element.setHeight(70);
		element.setXOffset(20);
		element.setYOffset(20);
		element.setColor(RgbColor.getViolet());
		element.setXDimension(2);
		element.setShowText(true);
		element.setAppendCheckDigit(MsiBarcodeCheckDigitMode.MOD1010);
		element.setEvenPages(true);
		element.setOddPages(true);

		template.getElements().add(element);
		input.setTemplate(template);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\TemplateBarcodeMsi.pdf");
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
