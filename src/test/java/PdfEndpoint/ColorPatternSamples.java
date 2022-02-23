package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.CmykColor;
import com.dynamicpdf.api.Grayscale;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.RgbColor;
import com.dynamicpdf.api.Template;
import com.dynamicpdf.api.elements.ElementPlacement;
import com.dynamicpdf.api.elements.TextElement;

public class ColorPatternSamples {
	
	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void PdfPageInput_NamedColorSample_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");
		
		PageInput input = new PageInput();
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        textElement.setColor(RgbColor.getRed());
        template.getElements().add(textElement);
        input.setTemplate(template);
		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\ColorPatternNamedColor.pdf");
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
	public void PdfPageInput_RGBColorSample_PdfOutput()
	{
		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");
		
		PageInput input = new PageInput();
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        textElement.setColor(new RgbColor(0, 1, 0));
        template.getElements().add(textElement);
        input.setTemplate(template);
		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\ColorPatternRGBColor.pdf");
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
	public void PdfPageInput_CMYKColorSample_PdfOutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");
		
		PageInput input = new PageInput();
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        textElement.setColor(new CmykColor(0, 1, 0, 0));
        template.getElements().add(textElement);
        input.setTemplate(template);
		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\ColorPatternCMYKColor.pdf");
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
	public void PdfPageInput_GrayScaleColorSample_PdfOutput()
	{

		Pdf pdf = new Pdf();
		pdf.setAuthor("Author");
		pdf.setTitle("Title");
		
		PageInput input = new PageInput();
        pdf.getInputs().add(input);

        Template template = new Template("Temp1");
        TextElement textElement = new TextElement("Hello World", ElementPlacement.TOPCENTER);
        textElement.setColor(new Grayscale(0.8f));
        template.getElements().add(textElement);
        input.setTemplate(template);
		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\ColorPatternGrayscale.pdf");
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
