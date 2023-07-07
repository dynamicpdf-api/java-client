package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.WordInput;
import com.dynamicpdf.api.WordResource;

public class WordInputSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void WordFile_pdfoutput() {
		Pdf pdf = new Pdf();

		WordResource wordResource = new WordResource("src\\test\\resources\\Doc1.docx");
		WordInput word = new WordInput(wordResource);

		word.setPageWidth(300);
		word.setPageHeight(200);

		word.setTopMargin(10f);
		word.setBottomMargin(10f);
		word.setRightMargin(40f);
		word.setLeftMargin(40f);

		pdf.getInputs().add(word);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\WordFile.pdf");
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
