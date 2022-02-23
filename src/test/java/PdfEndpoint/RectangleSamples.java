package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.*;
import com.dynamicpdf.api.elements.*;

public class RectangleSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void PageInput_Pdfoutput() {

		Pdf pdf = new Pdf();

		PageInput pageInput = new PageInput();	
		RectangleElement element = new RectangleElement(ElementPlacement.TOPCENTER, 100, 50);
		element.setXOffset(50);
		element.setYOffset(50);
		element.setCornerRadius(10);
		element.setBorderWidth(5);
		element.setBorderStyle(LineStyle.getDots());
		element.setBorderColor(RgbColor.getBlue());
		element.setFillColor(RgbColor.getGreen());
		pageInput.getElements().add(element);
		
		pdf.getInputs().add(pageInput);		
		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\RectangleSample.pdf");
			try {
				OutputStream os = new FileOutputStream(file);
				os.write(response.getContent());
				os.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
		assertEquals(response.getIsSuccessful(), true);
	}
}
