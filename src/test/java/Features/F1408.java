package Features;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dynamicpdf.api.AdditionalResourceType;
import com.dynamicpdf.api.DlexInput;
import com.dynamicpdf.api.DlexResource;
import com.dynamicpdf.api.ImageResource;
import com.dynamicpdf.api.LayoutDataResource;
import com.dynamicpdf.api.Pdf;
import com.dynamicpdf.api.PdfResponse;
import com.dynamicpdf.api.ResourceType;

public class F1408 {

	@BeforeClass
	public void setup()
	{
		ResourceBundle bundle =  ResourceBundle.getBundle("config");
		Pdf.setDefaultApiKey(bundle.getString("ApiKey"));
		Pdf.setDefaultBaseUrl(bundle.getString("BaseUrl"));
	}
	
	@Test
	public void SimpleDlexImage_AdditionalResource_Pdfoutput()
	{
		Pdf pdf = new Pdf();

        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\SimpleReportWithCoverPage.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input = new DlexInput(dlex, layoutData);
        pdf.getInputs().add(input);
        
        pdf.addAdditionalResource("src\\test\\resources\\PdfEndpoint\\Northwind Logo.gif");
        
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
	
	@Test
	public void SimpleDlexTemplate_AdditionalResource_Pdfoutput()
	{
		Pdf pdf = new Pdf();

        DlexResource dlex = new DlexResource("src\\test\\resources\\PdfEndpoint\\Invoice.dlex");
        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\InvoiceReportData.json");
        DlexInput input = new DlexInput(dlex, layoutData);
        pdf.getInputs().add(input);
        
        pdf.addAdditionalResource("src\\test\\resources\\PdfEndpoint\\Invoice.pdf");
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput1.pdf");
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
	
	@Test
	public void SimpleDlex_AdditionalResourceByteArray_Pdfoutput()
	{
		Pdf pdf = new Pdf();

        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\InvoiceReportData.json");
        DlexInput input = new DlexInput("Invoice.dlex", layoutData);
        pdf.getInputs().add(input);
        
        byte[] resourceData = null;
		try {
			resourceData = Files.readAllBytes(Paths.get("src\\test\\resources\\PdfEndpoint\\InvoiceTemplate.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        pdf.addAdditionalResource(resourceData, AdditionalResourceType.PDF, "InvoiceTemplate.pdf");
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput2.pdf");
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
	
	@Test
	public void SimpleDlex_AdditinalFontResource_Pdfoutput()
	{
		Pdf pdf = new Pdf();

        LayoutDataResource layoutData = new LayoutDataResource("src\\test\\resources\\PdfEndpoint\\SimpleReportData.json");
        DlexInput input = new DlexInput("SimpleDlexWithFont.dlex", layoutData);
        pdf.getInputs().add(input);
        
        pdf.addAdditionalResource("src\\test\\resources\\PdfEndpoint\\cour_0.ttf", "cour_0.ttf");
        pdf.addAdditionalResource("src\\test\\resources\\PdfEndpoint\\Calibri.otf", "Calibri.otf");
        pdf.addAdditionalResource("src\\test\\resources\\PdfEndpoint\\arialbi.ttf", "arialbi.ttf");
        
        PdfResponse response = pdf.process();
        
        if (response.getIsSuccessful()){
            File file = new File("C:\\Data\\outputs\\javaOutput3.pdf");
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
