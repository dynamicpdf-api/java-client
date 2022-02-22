package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PageInput;
import com.dynamicpdf.api.PdfResponse;
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
	public void PdfPageInput_Page_Pdfoutput()
    {
        Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        PageInput input = new PageInput();
        pdf.getInputs().add(input);

        ImageResource resource1 = new ImageResource("src\\test\\resources\\Northwind Logo.gif");
        ImageElement element = new ImageElement(resource1, ElementPlacement.TOPCENTER);
        element.setXOffset(50);
        element.setYOffset(50);
        element.setScaleX(3);
        element.setScaleY(3);
        input.getElements().add(element);
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\ImageElementSample.pdf");
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
