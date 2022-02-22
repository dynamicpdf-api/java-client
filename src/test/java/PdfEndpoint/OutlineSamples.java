package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.GoToAction;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.OutlineStyle;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PageZoom;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.UrlAction;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class OutlineSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void PdfInputUsingFilePath_Outline_GotoAction_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\SinglePage.pdf");
        PdfInput input1 = new PdfInput(resource1);
        pdf.getInputs().add(input1);

        Outline outline = pdf.getOutlines().add("OutlineA");
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        GoToAction linkTo = new GoToAction(input1);
        linkTo.setPageOffset(-5);
        linkTo.setPageZoom(PageZoom.FITPAGE);
        
        outline.setAction(linkTo);
        
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\OutlineGoToAction.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
				
	@Test
	public void PdfInputUsingFilePath_Outline_urlaction_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline3 = pdf.getOutlines().add("OutlineA");
        outline3.setExpanded(true);       
        outline3.setStyle(OutlineStyle.BOLD);
        outline3.setColor(RgbColor.getRed());

        UrlAction action3 = new UrlAction("https://www.dynamicpdf.com");
        outline3.setAction(action3);
              
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\OutlineUrlAction.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void AddOutlinesForNewPdf()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PageInput pageInput = pdf.addPage();
        TextElement element = new TextElement("Hello World 1", ElementPlacement.TOPCENTER);
        pageInput.getElements().add(element);
        
        PageInput pageInput1 = pdf.addPage();
        TextElement element1 = new TextElement("Hello World 2", ElementPlacement.TOPCENTER);
        pageInput1.getElements().add(element1);
        
        PageInput pageInput2 = pdf.addPage();
        TextElement element2 = new TextElement("Hello World 3", ElementPlacement.TOPCENTER);
        pageInput2.getElements().add(element2);
        
        Outline rootOutline = pdf.getOutlines().add("Root Outline");

        rootOutline.getChildren().add("Page 1", pageInput);
        rootOutline.getChildren().add("Page 2", pageInput1);
        rootOutline.getChildren().add("Page 3", pageInput2);
       
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\OutlinesForNewPdf.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void AddOutlinesForExsistingPdf()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource invoiceResource1 = new PdfResource("src\\test\\resources\\DocumentA100.pdf");
        PdfInput input1 = pdf.addPdf(invoiceResource1);
        input1.setId("document2");

        PdfResource invoiceResource2 = new PdfResource("src\\test\\resources\\InvoiceTemplate.pdf");
        PdfInput input2 = pdf.addPdf(invoiceResource2);
        input2.setId("invoice");
        
        Outline rootOutline = pdf.getOutlines().add("Root Outline");
        rootOutline.setExpanded(true);
        
        rootOutline.getChildren().add("DocumentA 100", input1, 0, PageZoom.FITPAGE);
        rootOutline.getChildren().add("Invoice", input2);
        
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\OutlinesForExsistingPd.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
	@Test
	public void MergeExsistingOutlinesWithRootoutline()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\AllPageElements.pdf");
		PdfInput input = pdf.addPdf(resource);
        input.setId("AllPageElements");
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfOutlineInput.pdf");
        PdfInput input1 = pdf.addPdf(resource1);
        input1.setId("outlineDoc1");
        pdf.getInputs().add(input1);

        Outline rootOutline = pdf.getOutlines().add("Imported Outline");
        rootOutline.setExpanded(true);

        rootOutline.getChildren().addPdfOutlines(input);
        rootOutline.getChildren().addPdfOutlines(input1);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\ImportOutlines.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}
