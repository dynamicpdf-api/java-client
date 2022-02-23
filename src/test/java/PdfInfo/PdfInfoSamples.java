package PdfInfo;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ResourceBundle;
import java.io.FileWriter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfInfo;
import com.dynamicpdf.api.PdfInfoResponse;
import com.dynamicpdf.api.PdfResource;

public class PdfInfoSamples  {

	@BeforeClass
    public void setup()
    {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		PdfInfo.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfInfo.setDefaultBaseUrl(bundle.getString("BaseUrl"));
    }
	
	@Test
	public static void AllFormFields_JsonOutput(){

		PdfResource resource = new PdfResource("src\\test\\resources\\AllFormFields.pdf");

		PdfInfo pdfInfo = new PdfInfo(resource);
		PdfInfoResponse response = pdfInfo.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfInfoAllFormFields.json");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getJsonContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
	
}
