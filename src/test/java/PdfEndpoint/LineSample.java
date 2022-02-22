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

public class LineSample {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void pageInput_Pdfoutput()
	{
		Pdf pdf = new Pdf();

		PageInput input = new PageInput();
		pdf.getInputs().add(input);

		LineElement element = new LineElement(ElementPlacement.TOPLEFT, 200, 200);
		element.setColor(new RgbColor(0, 0, 1));
		element.setXOffset(50);
		element.setYOffset(50);
		element.setLineStyle(LineStyle.getDashLarge());
		element.setWidth(4);
		input.getElements().add(element);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\LineSample.pdf");
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
