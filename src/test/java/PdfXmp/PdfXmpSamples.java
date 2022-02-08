package PdfXmp;

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
	public static void PdfXmpSample(){



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfXmp\\XmpMetadataSample.pdf");

		PdfXmp xmp = new PdfXmp(resource);
		XmlResponse response = xmp.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output.xml");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void XmpSingleResource(){



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfXmp\\bab6c782-2e85-4c6a-b248-9518a06549e900000.pdf");

		PdfXmp xmp = new PdfXmp(resource);
		XmlResponse response = xmp.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output1.xml");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void XmpSingleResource1(){



		PdfResource resource = new PdfResource("src\\test\\resources\\PdfXmp\\aaa_crash.pdf");

		PdfXmp xmp = new PdfXmp(resource);
		XmlResponse response = xmp.process();

		if (response.getIsSuccessful()){
			File file = new File("C:\\Data\\outputs\\Output2.xml");
			try {
				FileWriter fw=new FileWriter(file);    
				fw.write(response.getContent());    
				fw.close();  
			}
			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

	@Test
	public static void XmpMulitipleResource(){




		String [] pdfs= { "aaa_crash.pdf","bab6c782-2e85-4c6a-b248-9518a06549e900000.pdf","COR-GEN-2455447-1-A-1.pdf","Waiver TX AF.PDF" };
		for (int i = 0; i < pdfs.length; i++)
		{
			PdfResource resource = new PdfResource("src\\test\\resources\\PdfXmp\\"+pdfs[i]);

			PdfXmp xmp = new PdfXmp(resource);
			XmlResponse response = xmp.process();

			if (response.getIsSuccessful()){
				File file = new File("C:\\Data\\outputs\\MultiOutput"+i+".xml");
				try {
					FileWriter fw=new FileWriter(file);    
					fw.write(response.getContent());    
					fw.close();  
				}
				catch (Exception e) {
					System.out.println("Exception: " + e);
				}
			}
		}

	}
}

