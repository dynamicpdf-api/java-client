package Bugs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.DlexInput;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;


public class v1 {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void SimpleDlexImage_ResourceNotConsidering_Pdfoutput()
	{
		Pdf pdf = new Pdf();

        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input = new DlexInput(dlex, layoutData);
        pdf.getInputs().add(input);
        pdf.getResources().add(new ImageResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif", "Northwind Logo.gif"));

        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput.pdf");
            try {
                OutputStream os = new FileOutputStream(file);
                os.write(response.getContent());
                os.close();
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
	
	}
}
