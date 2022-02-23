package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.ImageInput;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;

public class ImageInputSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void FilePathImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");


        ImageResource resource = new ImageResource("src\\test\\resources\\DPDFLogo.png");
        ImageInput input = new ImageInput(resource);
        input.setScaleX(4);
        input.setScaleY(4);
        input.setPageWidth(400);
        input.setPageHeight(400);
        pdf.getInputs().add(input);
       
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\ImageInputPngImage.pdf");
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
	public void FilePathMulitiTiffImage_Pdfoutput()
    {
		Pdf pdf = new Pdf();
        pdf.setAuthor("Author");
        pdf.setTitle("Title");

        ImageResource resource = new ImageResource("src\\test\\resources\\fw9_18.tif");
        ImageInput input = new ImageInput(resource);
        input.setRightMargin(50);
        input.setBottomMargin(50);
        input.setTopMargin(50);
        input.setLeftMargin(50);
        pdf.getInputs().add(input);
       
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("src\\test\\outputs\\ImageInputMulitiTiffImage.pdf");
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
