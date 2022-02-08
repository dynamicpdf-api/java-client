package Complex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.Aes128Security;
import com.dynamicpdf.api.DlexInput;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.Font;
import com.dynamicpdf.api.GoToAction;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.LineStyle;
import com.dynamicpdf.api.MergeOptions;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.OutlineStyle;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PageZoom;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.AztecBarcodeElement;
import com.dynamicpdf.api.elements.Code11BarcodeElement;
import com.dynamicpdf.api.elements.Code128BarcodeElement;
import com.dynamicpdf.api.elements.Code25BarcodeElement;
import com.dynamicpdf.api.elements.Code39BarcodeElement;
import com.dynamicpdf.api.elements.Code93BarcodeElement;
import com.dynamicpdf.api.elements.DataMatrixBarcodeElement;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.Gs1DataBarBarcodeElement;
import com.dynamicpdf.api.elements.Gs1DataBarType;
import com.dynamicpdf.api.elements.Iata25BarcodeElement;
import com.dynamicpdf.api.elements.ImageElement;
import com.dynamicpdf.api.elements.LineElement;
import com.dynamicpdf.api.elements.MsiBarcodeElement;
import com.dynamicpdf.api.elements.PageNumberingElement;
import com.dynamicpdf.api.elements.Pdf417BarcodeElement;
import com.dynamicpdf.api.elements.QrCodeElement;
import com.dynamicpdf.api.elements.RectangleElement;
import com.dynamicpdf.api.elements.StackedGs1DataBarBarcodeElement;
import com.dynamicpdf.api.elements.StackedGs1DataBarType;
import com.dynamicpdf.api.elements.TextElement;

public class ComplexSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void PdfInputPageInput_PageAndPdf_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        
        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("First Page", ElementPlacement.TOPLEFT);

        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);

        PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(pdfResource);
        pdf.getInputs().add(pdfInput);

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void PageInput_SamePageInput_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");
        
        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);

        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);
        pdf.getInputs().add(pageInput);
        pdf.getInputs().add(pageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput1.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void PageInput_PageInputWithSameFont_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        
        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
        element.setFont(font);
        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);

        PageInput pageInput1 = new PageInput();
        TextElement element1 = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        Font font1 = Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf");
        element1.setFont(font1);
        pageInput1.getElements().add(element1);
        pdf.getInputs().add(pageInput1);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput2.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void PageInput_SamePageInputWithImage_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        
        PageInput pageInput = new PageInput();
        ImageResource imageResource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageElement imageElement = new ImageElement(imageResource, ElementPlacement.TOPLEFT);

        pageInput.getElements().add(imageElement);
        pdf.getInputs().add(pageInput);
        pdf.getInputs().add(pageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput3.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void PdfInput_MergeSamePdfInput_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(resource);
        pdf.getInputs().add(pdfInput);
        pdf.getInputs().add(pdfInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput4.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void PdfInputPageInput_MergeSamePdfAndAppendPage_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("First Page", ElementPlacement.TOPLEFT);
        element.setColor(RgbColor.getRed());
        element.setFont(Font.getCourierBold());
        element.setFontSize(20);
        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(resource);
        pdf.getInputs().add(pdfInput);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput1 = new PdfInput(resource1);
        pdf.getInputs().add(pdfInput1);

        PdfInput pdfInput2 = new PdfInput("DocumentA100.pdf");
        pdf.getInputs().add(pdfInput2);

        PageInput pageInput1 = new PageInput();
        TextElement element1 = new TextElement("Last Page", ElementPlacement.TOPLEFT);
        element1.setColor(RgbColor.getBlue());
        element1.setFont(Font.getTimesItalic());
        element1.setFontSize(20);
        pageInput1.getElements().add(element1);
        pdf.getInputs().add(pageInput1);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput5.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
	
	@Test
	public void ImageInput_AddSameImageInput_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageInput imageInput = new ImageInput(resource);
        pdf.getInputs().add(imageInput);
        pdf.getInputs().add(imageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput6.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void ImageInputPageInputPdfInput_AddSameImages_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Add Same Image Resource", ElementPlacement.TOPLEFT);
        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);

        ImageResource resource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageInput imageInput = new ImageInput(resource);
        pdf.getInputs().add(imageInput);

        ImageResource resource1 = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageInput imageInput1 = new ImageInput(resource1);
        imageInput1.setTopMargin(50);
        imageInput1.setBottomMargin(50);
        imageInput1.setLeftMargin(50);
        imageInput1.setRightMargin(50);
        pdf.getInputs().add(imageInput1);

        ImageResource resource2 = new ImageResource("src\\test\\resources\\PdfEndpoint\\170x220_T.png");
        ImageInput imageInput2 = new ImageInput(resource2);
        pdf.getInputs().add(imageInput2);

        ImageInput imageInput3 = new ImageInput("Image1.jpg");
        pdf.getInputs().add(imageInput3);

        PdfResource resource3 = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(resource3);
        ImageElement imageElement = new ImageElement(resource1, ElementPlacement.TOPLEFT);
        imageElement.setXOffset(25);
        imageElement.setYOffset(25);
        Template template = new Template("Temp1");
        template.getElements().add(imageElement);
        pdfInput.setTemplate(template);
        pdf.getInputs().add(pdfInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput7.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void DlexInputPageInput_AddSameDlexInput_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        ImageResource img = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif", "northwind logo.gif");
        pdf.getResources().add(img);

        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input = new DlexInput(dlex, layoutData);
        pdf.getInputs().add(input);
        pdf.getInputs().add(input);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput8.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void DlexInputPageInput_AddSameDlex_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        element.setFontSize(20);
        pageInput.getElements().add(element);
        pdf.getInputs().add(pageInput);

        ImageResource img = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif", "northwind logo.gif");
        pdf.getResources().add(img);

        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input = new DlexInput(dlex, layoutData);
        pdf.getInputs().add(input);

        DlexResource dlex1 = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData1 = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input1 = new DlexInput(dlex1, layoutData1);
        pdf.getInputs().add(input1);

        String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        DlexInput input2 = new DlexInput("SimpleReportWithCoverPage.dlex", jsonString);
        pdf.getInputs().add(input2);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput9.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void PdfInputPageInput_ElemetsWithSecurity_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        Aes128Security aes128Security = new Aes128Security("", "owner");
        aes128Security.setAllowPrint(false);
        pdf.setSecurity(aes128Security);

        PageInput pageInput = new PageInput();
        RectangleElement rectangleElement = new RectangleElement(ElementPlacement.TOPLEFT, 100, 100);
        rectangleElement.setBorderColor(RgbColor.getRed());
        rectangleElement.setFillColor(RgbColor.getGreen());
        rectangleElement.setBorderWidth(3);
        pageInput.getElements().add(rectangleElement);

        TextElement textElement = new TextElement("Rectangle Element", ElementPlacement.TOPCENTER);
        pageInput.getElements().add(textElement);
        pdf.getInputs().add(pageInput);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(resource);
        Template template = new Template("Temp1");

        LineElement lineElement = new LineElement(ElementPlacement.TOPLEFT, 600, 50);
        lineElement.setColor(RgbColor.getBlue());
        lineElement.setXOffset(10);
        lineElement.setYOffset(50);
        lineElement.setWidth(2);
        lineElement.setLineStyle(LineStyle.getDots());
        template.getElements().add(lineElement);
        pdfInput.setTemplate(template);
        pdf.getInputs().add(pdfInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput10.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void PageInputImageInput_DifferentElemnts_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        textElement.setFontSize(40);
        pageInput.getElements().add(textElement);

        PageNumberingElement pageNumbering = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPCENTER);
        pageNumbering.setYOffset(-20);
        pageInput.getElements().add(pageNumbering);

        RectangleElement rectangleElement = new RectangleElement(ElementPlacement.TOPLEFT, 200, 150);
        rectangleElement.setYOffset(100);
        pageInput.getElements().add(rectangleElement);

        LineElement lineElement = new LineElement(ElementPlacement.TOPLEFT, 400, 400);
        lineElement.setYOffset(400);
        lineElement.setColor(RgbColor.getRed());
        pageInput.getElements().add(lineElement);

        Font font = Font.fromFile("src\\test\\resources\\PdfEndpoint\\Calibri.otf");
        Code128BarcodeElement code128BarcodeElement = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.BOTTOMLEFT, 50);
        code128BarcodeElement.setFont(font);
        pageInput.getElements().add(code128BarcodeElement);

        AztecBarcodeElement aztecBarcodeElement = new AztecBarcodeElement("Hello World", ElementPlacement.BOTTOMRIGHT);
        aztecBarcodeElement.setColor(RgbColor.getBlue());
        pageInput.getElements().add(aztecBarcodeElement);
        pdf.getInputs().add(pageInput);

        PageInput pageInput1 = new PageInput();
        ImageResource imageResource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageElement imageElement = new ImageElement(imageResource, ElementPlacement.TOPLEFT);
        imageElement.setScaleX(0.5f);
        imageElement.setScaleY(0.5f);
        pageInput1.getElements().add(imageElement);
        pageInput1.getElements().add(pageNumbering);
        pdf.getInputs().add(pageInput1);

        Template template = new Template("TempA");
        template.getElements().add(pageNumbering);

        ImageInput imageInput = new ImageInput(imageResource);
        imageInput.setTopMargin(50);
        imageInput.setTemplate(template);
        pdf.getInputs().add(imageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput11.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void Inputs_DifferentInputs_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfInput pdfInput = new PdfInput("DocumentA100.pdf");
        MergeOptions mergeOptions = new MergeOptions();
        pdfInput.setMergeOptions(mergeOptions);
        pdf.getInputs().add(pdfInput);

        PageInput pageInput = new PageInput();
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        textElement.setFontSize(40);
        pageInput.getElements().add(textElement);
        pdf.getInputs().add(pageInput);

        ImageResource img = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif", "northwind logo.gif");
        pdf.getResources().add(img);
        
        String jsonString = null;
		
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        DlexInput dlexInput = new DlexInput("SimpleReportWithCoverPage.dlex", jsonString);
        pdf.getInputs().add(dlexInput);

        ImageInput imageInput = new ImageInput("Image1.jpg");
        imageInput.setTopMargin(10);
        imageInput.setLeftMargin(10);
        imageInput.setRightMargin(10);
        imageInput.setBottomMargin(10);
        pdf.getInputs().add(imageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput12.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void PageInputs_DifferentBarcode_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement textElement = new TextElement("1D Barcodes", ElementPlacement.TOPCENTER, 0, -20);
        pageInput.getElements().add(textElement);

        TextElement element1 = new TextElement("Code128Barcode", ElementPlacement.TOPLEFT, 0, 20);
        pageInput.getElements().add(element1);
        Code128BarcodeElement code128BarcodeElement = new Code128BarcodeElement("Code 128 Barcode.", ElementPlacement.TOPLEFT, 50);
        code128BarcodeElement.setYOffset(50);
        pageInput.getElements().add(code128BarcodeElement);

        TextElement element2 = new TextElement("Code39Barcode", ElementPlacement.TOPRIGHT, 0, 20);
        pageInput.getElements().add(element2);
        Code39BarcodeElement code39BarcodeElement = new Code39BarcodeElement("CODE 39", ElementPlacement.TOPRIGHT, 50);
        code39BarcodeElement.setYOffset(50);
        pageInput.getElements().add(code39BarcodeElement);

        TextElement element3 = new TextElement("Code25Barcode", ElementPlacement.TOPLEFT, 0, 220);
        pageInput.getElements().add(element3);
        Code25BarcodeElement code25BarcodeElement = new Code25BarcodeElement("1234567890", ElementPlacement.TOPLEFT, 50);
        code25BarcodeElement.setYOffset(250);
        pageInput.getElements().add(code25BarcodeElement);

        TextElement element4 = new TextElement("Code93Barcode", ElementPlacement.TOPCENTER, 0, 220);
        pageInput.getElements().add(element4);
        Code93BarcodeElement code93BarcodeElement = new Code93BarcodeElement("CODE 93", ElementPlacement.TOPCENTER, 50);
        code93BarcodeElement.setYOffset(250);
        pageInput.getElements().add(code93BarcodeElement);

        TextElement element5 = new TextElement("Code11Barcode", ElementPlacement.TOPRIGHT, 0, 220);
        pageInput.getElements().add(element5);
        Code11BarcodeElement code11BarcodeElement = new Code11BarcodeElement("12345678", ElementPlacement.TOPRIGHT, 50);
        code11BarcodeElement.setYOffset(250);
        pageInput.getElements().add(code11BarcodeElement);

        TextElement element6 = new TextElement("Gs1DataBarBarcode", ElementPlacement.TOPLEFT, 0, 420);
        pageInput.getElements().add(element6);
        Gs1DataBarBarcodeElement gs1DataBarBarcodeElement = new Gs1DataBarBarcodeElement("12345678", ElementPlacement.TOPLEFT, 50, Gs1DataBarType.OMNIDIRECTIONAL);
        gs1DataBarBarcodeElement.setYOffset(450);
        pageInput.getElements().add(gs1DataBarBarcodeElement);

        TextElement element7 = new TextElement("StackedGs1DataBarBarcode", ElementPlacement.TOPCENTER, 0, 420);
        pageInput.getElements().add(element7);
        StackedGs1DataBarBarcodeElement stackedGs1DataBarBarcodeElement = new StackedGs1DataBarBarcodeElement("12345678", ElementPlacement.TOPCENTER, StackedGs1DataBarType.STACKED, 25);
        stackedGs1DataBarBarcodeElement.setYOffset(450);
        pageInput.getElements().add(stackedGs1DataBarBarcodeElement);

        TextElement element8 = new TextElement("Iata25Barcode", ElementPlacement.TOPRIGHT, 0, 420);
        pageInput.getElements().add(element8);
        Iata25BarcodeElement iata25BarcodeElement = new Iata25BarcodeElement("12345678", ElementPlacement.TOPRIGHT, 50);
        iata25BarcodeElement.setYOffset(450);
        pageInput.getElements().add(iata25BarcodeElement);

        TextElement element9 = new TextElement("MsiBarcode", ElementPlacement.TOPCENTER, 0, 620);
        pageInput.getElements().add(element9);
        MsiBarcodeElement msiBarcodeElement = new MsiBarcodeElement("1234567890", ElementPlacement.TOPCENTER, 50);
        msiBarcodeElement.setYOffset(650);
        pageInput.getElements().add(msiBarcodeElement);

        pdf.getInputs().add(pageInput);

        PageInput pageInput1 = new PageInput();
        TextElement textElement1 = new TextElement("2D Barcodes", ElementPlacement.TOPCENTER, 0, -20);
        pageInput1.getElements().add(textElement1);

        TextElement element10 = new TextElement("AztecBarcode", ElementPlacement.TOPLEFT, 0, 20);
        pageInput1.getElements().add(element10);
        AztecBarcodeElement aztecBarcodeElement = new AztecBarcodeElement("Hello World", ElementPlacement.TOPLEFT);
        aztecBarcodeElement.setYOffset(50);
        pageInput1.getElements().add(aztecBarcodeElement);

        TextElement element11 = new TextElement("DataMatrixBarcode", ElementPlacement.TOPRIGHT, 0, 20);
        pageInput1.getElements().add(element11);
        DataMatrixBarcodeElement dataMatrixBarcodeElement = new DataMatrixBarcodeElement("Hello World", ElementPlacement.TOPRIGHT);
        dataMatrixBarcodeElement.setYOffset(50);
        pageInput1.getElements().add(dataMatrixBarcodeElement);

        TextElement element12 = new TextElement("Pdf417Barcode", ElementPlacement.TOPLEFT, 0, 170);
        pageInput1.getElements().add(element12);
        Pdf417BarcodeElement pdf417BarcodeElement = new Pdf417BarcodeElement("Hello World", ElementPlacement.TOPLEFT, 3);
        pdf417BarcodeElement.setYOffset(200);
        pageInput1.getElements().add(pdf417BarcodeElement);

        TextElement element13 = new TextElement("QrCode", ElementPlacement.TOPRIGHT, 0, 170);
        pageInput1.getElements().add(element13);
        QrCodeElement qrCodeElement = new QrCodeElement("Hello World", ElementPlacement.TOPRIGHT);
        qrCodeElement.setYOffset(200);
        pageInput1.getElements().add(qrCodeElement);

        pdf.getInputs().add(pageInput1);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput13.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
	
	@Test
	public void PdfInputPageInput_ElementsWithOutlines_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        pageInput.setId("page1");
        TextElement textElement = new TextElement("Page Input With Eelements", ElementPlacement.TOPLEFT);
        textElement.setFont(Font.fromFile("src\\test\\resources\\PdfEndpoint\\verdanab.ttf"));
        textElement.setFontSize(20);
        textElement.setColor(new RgbColor(1, 0, 0));
        pageInput.getElements().add(textElement);

        LineElement lineElement = new LineElement(ElementPlacement.TOPLEFT, 400, 50);
        lineElement.setYOffset(50);
        lineElement.setColor(RgbColor.getYellow());
        pageInput.getElements().add(lineElement);

        Template template = new Template("TemplatePage");
        PageNumberingElement pageNumberingElement = new PageNumberingElement("%%CP%% of %%TP%%", ElementPlacement.TOPRIGHT);
        pageNumberingElement.setFont(Font.getCourier());
        template.getElements().add(pageNumberingElement);
        pageInput.setTemplate(template);

        Outline outline = pdf.getOutlines().add("Outline Page Input");
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        GoToAction linkTo = new GoToAction(pageInput);
        linkTo.setPageZoom(PageZoom.FITPAGE);

        outline.setAction(linkTo);

        pdf.getInputs().add(pageInput);

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput pdfInput = new PdfInput(resource);
        pdfInput.setId("pdf1");
        pdfInput.setTemplate(template);

        Outline outline1 = pdf.getOutlines().add("Outline Pdf Input");
        outline1.setStyle(OutlineStyle.ITALIC);

        GoToAction linkTo1 = new GoToAction(pdfInput);
        linkTo1.setPageZoom(PageZoom.FITHEIGHT);

        outline1.setAction(linkTo1);
        pdf.getInputs().add(pdfInput);

        ImageResource img = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif", "northwind logo.gif");
        pdf.getResources().add(img);
        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput dlexInput = new DlexInput(dlex, layoutData);
        dlexInput.setId("dlex1");

        Outline outline2 = pdf.getOutlines().add("Outline Dlex Input");
        outline2.setStyle(OutlineStyle.REGULAR);
        outline2.setColor(RgbColor.getGreen());

        GoToAction linkTo2 = new GoToAction(dlexInput);
        linkTo2.setPageZoom(PageZoom.FITHEIGHT);

        outline2.setAction(linkTo2);
        pdf.getInputs().add(dlexInput);

        ImageResource imageResource = new ImageResource("src\\test\\resources\\PdfEndpoint\\Image1.jpg");
        ImageInput imageInput = new ImageInput(imageResource);
        imageInput.setTopMargin(50);
        imageInput.setLeftMargin(50);
        imageInput.setRightMargin(50);
        imageInput.setBottomMargin(50);
        imageInput.setId("img1");

        Outline outline3 = pdf.getOutlines().add("Outline Image Input");
        outline3.setStyle(OutlineStyle.REGULAR);
        outline3.setColor(RgbColor.getBlue());

        GoToAction linkTo3 = new GoToAction(imageInput);
        linkTo3.setPageZoom(PageZoom.FITHEIGHT);

        outline3.setAction(linkTo3);

        pdf.getInputs().add(imageInput);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput14.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	}
}
