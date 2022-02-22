package ImageInfo;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.ResourceBundle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.dynamicpdf.api.ImageInfo;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.ImageResponse;


public class ImageInfoSamples {


	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		ImageInfo.setDefaultApiKey(bundle.getString("ApiKey"));
		ImageInfo.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void MultipleFormats_JsonOutput()
	{
		String[] images = { "Northwind Logo.gif", "fw9_18.tif", "DPDFLogo.png", "DocumentA.jpeg" };

		for (int i = 0; i < images.length; i++) {
			ImageResource resource = new ImageResource("src\\test\\resources\\" +images[i]);

			ImageInfo pdfEndPoint = new ImageInfo(resource);
			ImageResponse response = pdfEndPoint.process();
			if (response.getIsSuccessful()){
				File file = new File("src\\test\\outputs\\ImageInfoMultipleFormats"+i+".json");
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

}
