package PdfXmp;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.PdfResource;
import com.dynamicpdf.api.PdfXmp;
import com.dynamicpdf.api.XmlResponse;

public class PdfXmpSamples {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		PdfXmp.setDefaultApiKey(bundle.getString("ApiKey"));
		PdfXmp.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public static void XmpResource()
	{
		PdfResource resource = new PdfResource("src\\test\\resources\\XmpAndOtherSample.pdf");

		PdfXmp xmp = new PdfXmp(resource);
		XmlResponse response = xmp.process();

		if (response.getIsSuccessful()){
			File file = new File("src\\test\\outputs\\PdfXmpSample.xml");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}

