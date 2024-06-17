package PdfEndpoint;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.ExcelResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.ExcelInput;

public class ExcelInputSamples {

	@BeforeClass
	public void setup() {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}

	@Test
	public void ExcelFile_pdfoutput() {
		Pdf pdf = new Pdf();

		ExcelResource excelResource = new ExcelResource("src\\test\\resources\\DocumentA.xlsx");
		ExcelInput excel = new ExcelInput(excelResource);

		excel.setPageWidth(300f);
		excel.setPageHeight(200f);

		excel.setTopMargin(10f);
		excel.setBottomMargin(10f);
		excel.setRightMargin(40f);
		excel.setLeftMargin(40f);

		pdf.getInputs().add(excel);

		PdfResponse response = pdf.process();

		if (response.getIsSuccessful()) {
			File file = new File("src\\test\\outputs\\ExcelFile.pdf");
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
