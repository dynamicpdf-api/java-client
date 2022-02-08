package PdfEndpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfInput;
import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.ImageElement;

public class ImageElementSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void PdfInputUsingFilePath_WithTemplate_Pdfoutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        ImageResource resource1 = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        ImageElement element = new ImageElement(resource1, ElementPlacement.TOPCENTER);
        template.getElements().add(element);
        input.setTemplate(template);

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
	public void PdfInputUsingFilePath_Templatescale_Pdfoutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfResource resource = new PdfResource("src\\test\\resources\\PdfEndpoint\\DocumentA100.pdf");
        PdfInput input = new PdfInput(resource);
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        ImageResource resource1 = new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        ImageElement element = new ImageElement(resource1, ElementPlacement.TOPCENTER);
        element.setScaleX(3);
        element.setScaleY(3);
        template.getElements().add(element);
        input.setTemplate(template);

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
	public void PdfInputUsingCloudRoot_Template_Pdfoutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PdfInput input = new PdfInput("DocumentA100.pdf");
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        ImageElement element = new ImageElement("Northwind Logo.gif", ElementPlacement.TOPCENTER);
        element.setScaleX(3);
        element.setScaleY(3);
        template.getElements().add(element);
        input.setTemplate(template);

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
}
