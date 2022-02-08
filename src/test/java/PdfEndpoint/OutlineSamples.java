package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.DlexLayout;
import com.dynamicpdf.api.GoToAction;
import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Outline;
import com.dynamicpdf.api.OutlineStyle;
import com.dynamicpdf.api.PageZoom;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.UrlAction;

public class OutlineSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void PdfInputUsingFilePath_Outline_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
		PdfInput input = new PdfInput(resource);
		pdf.getInputs().add(input);

		Outline outline = pdf.getOutlines().add("OutlineA");
		outline.setColor(RgbColor.getRed());
		outline.setStyle(OutlineStyle.BOLD);
		outline.setExpanded(true);

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
	public void PdfInputUsingFilePath_OutlineAll_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        PdfInput invoiceInput = new PdfInput(invoiceResource);
        pdf.getInputs().add(invoiceInput);

        ImageResource imageResource = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        ImageInput imageInput = new ImageInput(imageResource);
        pdf.getInputs().add(imageInput);

        PdfResource mergeOutlineResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\MergeOutlineInput.pdf");
        PdfInput mergeOutlineInput = new PdfInput(mergeOutlineResource);
        pdf.getInputs().add(mergeOutlineInput);

        Outline outline = pdf.getOutlines().add("Invoice", invoiceInput);

        Outline outline1 = pdf.getOutlines().add("Picture", imageInput);

        Outline outline2 = pdf.getOutlines().add("Outlines in Doc A 100");
        outline2.getChildren().addPdfOutlines(mergeOutlineInput);

        Outline outline3 = pdf.getOutlines().add("DynamicPDF is Cool!", "https://www.dynamicpdf.com");

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
	public void PdfInputUsingFilePath_ChildrenSimplegoto_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource emptyPagesresource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput emptyInput = new PdfInput(emptyPagesresource);
        pdf.getInputs().add(emptyInput);

        PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput documentA100Input = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100Input);

        Outline outline = pdf.getOutlines().add("OutlineA", emptyInput, 5, PageZoom.FITPAGE);
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        Outline OutlineA1 = pdf.getOutlines().add("OutlineA1", documentA100Input,10,PageZoom.FITPAGE);
        OutlineA1.setColor(RgbColor.getRed());
        OutlineA1.setStyle(OutlineStyle.BOLD);
        OutlineA1.setExpanded(true);

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
	public void PdfInputUsingFilePath_children_simplegotoOutOfPageIndexLeve1_Exception()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource emptyPagesresource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput emptyInput = new PdfInput(emptyPagesresource);
        pdf.getInputs().add(emptyInput);
        
        PdfInput emptyInput1 = new PdfInput(emptyPagesresource);
        pdf.getInputs().add(emptyInput1);

        PdfResource documentA100Resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput documentA100Input = new PdfInput(documentA100Resource);
        pdf.getInputs().add(documentA100Input);

        Outline outline = pdf.getOutlines().add("OutlineA", emptyInput, 5, PageZoom.FITPAGE);
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        Outline OutlineA1 = pdf.getOutlines().add("OutlineA1", emptyInput1, -10, PageZoom.FITPAGE);
        OutlineA1.setColor(RgbColor.getRed());
        OutlineA1.setStyle(OutlineStyle.BOLD);
        OutlineA1.setExpanded(true);

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
	public void PdfInputUsingFilePath_OutlineFrominputidFromChildren_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		 PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\MergeOutlineInput.pdf");
         PdfInput input2 = new PdfInput(resource2);
         pdf.getInputs().add(input2);

         Outline outline2 = pdf.getOutlines().add("Outlines in Doc A 100");
         outline2.getChildren().addPdfOutlines(input2);

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
	public void PdfInputUsingFilePath_OutlineFrominputidFromParent_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource invoiceResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        PdfInput invoiceInput = new PdfInput(invoiceResource);
        pdf.getInputs().add(invoiceInput);

        ImageResource imageResource = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.tif");
        ImageInput imageInput = new ImageInput(imageResource);
        pdf.getInputs().add(imageInput);

        PdfResource mergeOutlineResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\MergeOutlineInput.pdf");
        PdfInput mergeOutlineInput = new PdfInput(mergeOutlineResource);
        pdf.getInputs().add(mergeOutlineInput);

        Outline outline = pdf.getOutlines().add("Invoice", invoiceInput);

        Outline outline1 = pdf.getOutlines().add("Picture",imageInput);

        pdf.getOutlines().addPdfOutlines(mergeOutlineInput);

        Outline outline3 = pdf.getOutlines().add("DynamicPDF is Cool!", "https://www.dynamicpdf.com");


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
	public void PdfInputUsingFilePath_Outline_GotoAction_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\SinglePage.pdf");
        PdfInput input1 = new PdfInput(resource1);

        pdf.getInputs().add(input1);

        Outline outline = pdf.getOutlines().add("OutlineA", input1, -5, PageZoom.FITPAGE);
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

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
	public void PdfInputUsingFilePath_Outline_KidsBlankPageGotoAction_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline = pdf.getOutlines().add("OutlineA");
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);
        
        Outline outline1 = pdf.getOutlines().add("OutlineA1", input, 3);
        outline1.setColor(RgbColor.getBlue());

        Outline outline2 = pdf.getOutlines().add("OutlineA2", input, 5);
        outline2.setColor(RgbColor.getBlue());

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
	public void PdfInputUsingFilePath_OutlineSameLevel_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline = pdf.getOutlines().add("Invoice", input);

        Outline outline3 = pdf.getOutlines().add("DynamicPDF is Cool!", "https://www.dynamicpdf.com");

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
	public void PdfInputUsingFilePath_OutlineSimpleFromInputId_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\OutlineInput.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline = pdf.getOutlines().add("outlineroot");
        outline.setStyle(OutlineStyle.ITALIC);
        outline.setExpanded(true);
        outline.setColor(new RgbColor(1, 0, 0));

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
	public void PdfInputUsingFilePath_Outlines_simplegoto_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput input1 = new PdfInput(resource1);
        pdf.getInputs().add(input1);

        Outline outline = pdf.getOutlines().add("OutlineA", input1, -2, PageZoom.FITPAGE);
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

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
	public void PdfInputUsingFilePath_Outlines_simplegoto_mulitiple_inputs_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput input1 = new PdfInput(resource1);
        input1.setId("document2");
        pdf.getInputs().add(input1);

        Outline outline = pdf.getOutlines().add("OutlineA",input1,-2,PageZoom.FITPAGE);
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);
        
        Outline outline2 = pdf.getOutlines().add("Outline2A", input1, 1, PageZoom.FITPAGE);
        outline2.setColor(RgbColor.getBlue());
        outline2.setStyle(OutlineStyle.BOLD);
        outline2.setExpanded(true);

        Outline OutlineA1 = pdf.getOutlines().add("OutlineA1", input1, 10, PageZoom.FITPAGE);
        OutlineA1.setColor(RgbColor.getRed());
        OutlineA1.setStyle(OutlineStyle.BOLD);
        OutlineA1.setExpanded(true);

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
	public void PdfInputUsingFilePath_Outline_urlaction_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline3 = pdf.getOutlines().add("OutlineA", "https://www.dynamicpdf.com/");
        outline3.setColor(RgbColor.getRed());
        outline3.setStyle(OutlineStyle.BOLD);
        outline3.setExpanded(true);

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
	public void PdfInputUsingFilePath_Outlines_with_children_one_level_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Outline outline = pdf.getOutlines().add("Outline1");
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        Outline outline1A = outline.getChildren().add("Outline1A");
        outline1A.setColor(RgbColor.getBlue());
        outline1A.setStyle(OutlineStyle.BOLD);
        outline1A.setExpanded(true);

        Outline outline1 = pdf.getOutlines().add("Outline2");
        outline1.setColor(RgbColor.getRed());
        outline1.setStyle(OutlineStyle.BOLD);
        outline1.setExpanded(true);

        Outline outline2A = pdf.getOutlines().add("Outline2A");
        outline2A.setColor(RgbColor.getBlue());
        outline2A.setStyle(OutlineStyle.BOLD);
        outline2A.setExpanded(true);

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
	public void PdfInputUsingFilePath_ChildrenFrominputIds_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\EmptyPages.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);
        
        PdfResource resource2 = new PdfResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        PdfInput input2 = new PdfInput(resource2);
        pdf.getInputs().add(input2);

        PdfResource resource1 = new PdfResource("src\\test\\resources\\PdfEndpoint\\PdfOutlineInput.pdf");
        PdfInput input1 = new PdfInput(resource1);
        pdf.getInputs().add(input1);

        ImageResource resource3 = new ImageResource("src\\test\\resources\\PdfEndpoint\\CCITT_1.TIF");
        ImageInput input3 = new ImageInput(resource3);
        pdf.getInputs().add(input3);
        
        Outline outline = pdf.getOutlines().add("Outline1");
        outline.setColor(RgbColor.getRed());
        outline.setStyle(OutlineStyle.BOLD);
        outline.setExpanded(true);

        Outline outline1A = outline.getChildren().add("Outline1A");
        outline1A.setColor(RgbColor.getBlue());
        outline1A.setStyle(OutlineStyle.BOLD);
        outline1A.setExpanded(true);

        Outline outline1A1 = outline1A.getChildren().add("Outline1A1");
        outline1A1.setColor(RgbColor.getGreen());
        outline1A1.setStyle(OutlineStyle.BOLD);
        outline1A1.setExpanded(true);

        Outline outline1A2 = outline1A.getChildren().add("Outline1A2", input3);
        outline1A2.setColor(RgbColor.getGreen());
        outline1A2.setStyle(OutlineStyle.BOLD);
        outline1A2.setExpanded(true);

        Outline outline1B = outline.getChildren().add("Outline1B");
        outline1B.setColor(RgbColor.getRed());
        outline1B.setStyle(OutlineStyle.BOLD);
        outline1B.setExpanded(true);

        Outline outline2 = pdf.getOutlines().add("Outline2");
        outline2.setColor(RgbColor.getRed());
        outline2.setStyle(OutlineStyle.BOLD);
        outline2.setExpanded(true);

        Outline outline2A = outline2.getChildren().add("Outline2A");
        outline2A.setColor(RgbColor.getBlue());
        outline2A.setStyle(OutlineStyle.BOLD);
        outline2A.setExpanded(true);

        Outline outline2A1 = outline2A.getChildren().add("Outline2A1");
        outline2A1.setColor(RgbColor.getGreen());
        outline2A1.setStyle(OutlineStyle.BOLD);
        outline2A1.setExpanded(true);

        Outline outline2A2 = outline2A.getChildren().add("Outline2A2");
        outline2A2.setColor(RgbColor.getGreen());
        outline2A2.setStyle(OutlineStyle.BOLD);
        outline2A2.setExpanded(true);

        outline2.getChildren().addPdfOutlines(input1);
        
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
	public void PdfInput_ChildrenFrominputIds_Pdfoutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");

		PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\AllPageElements.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);
        
        pdf.getOutlines().addPdfOutlines(input);

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
