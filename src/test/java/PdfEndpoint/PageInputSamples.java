package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.LineStyle;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.LineElement;
import com.dynamicpdf.api.elements.TextElement;

public class PageInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void PageInput_TextElement_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        pageInput.getElements().add(element);

        pdf.getInputs().add(pageInput);
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
	public void PageInput_TextElementAddedToPageAndTemplate_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput pageInput = new PageInput();
        TextElement element = new TextElement("Hello World", ElementPlacement.TOPLEFT);
        pageInput.getElements().add(element);

        Template template = new Template("Temp1");
        TextElement element1 = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        template.getElements().add(element1);

        pageInput.setTemplate(template);
        
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
	public void PageInput_AddPage_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput input = pdf.addPage();

        LineElement element = new LineElement(ElementPlacement.TOPCENTER, 200, 200);
        element.setLineStyle(LineStyle.getDots());

        input.getElements().add(element);
        
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
	public void PageInput_AddPageTemplate_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput input = pdf.addPage();

        TextElement element = new TextElement("test", ElementPlacement.TOPCENTER);
        Template template = new Template("temp");
        template.getElements().add(element);

        input.setTemplate(template);
        
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
	public void PageInput_AddPageParameters_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput input = pdf.addPage(500, 500);

        TextElement element = new TextElement("test", ElementPlacement.TOPCENTER);
        input.getElements().add(element);
        
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
	public void AddPageAndPdfInput_Pdfoutput()
    { 
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource pdfResource = new PdfResource("src\\test\\resources\\PdfEndpoint\\Emptypages.pdf");
        PdfInput pdfInput = new PdfInput(pdfResource);
        pdf.getInputs().add(pdfInput);

        PageInput input = pdf.addPage();

        TextElement element = new TextElement("test", ElementPlacement.TOPCENTER);
        input.getElements().add(element);
        
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
}
